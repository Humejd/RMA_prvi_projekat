package com.example.miniimdb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    private List<Film> listaFilmova;
    private List<Film> listaFilmovaOriginal;

    public FilmAdapter(List<Film> listaFilmova) {
        this.listaFilmova = listaFilmova;
        this.listaFilmovaOriginal = new ArrayList<>(listaFilmova);
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View prikaz = LayoutInflater.from(parent.getContext()).inflate(R.layout.stavka_film, parent, false);
        return new FilmViewHolder(prikaz);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        Film film = listaFilmova.get(position);

        holder.ivSlikaFilma.setImageResource(film.getSlikaID());
        holder.tvNaslov.setText(film.getNaslov());
        holder.tvZanr.setText("Žanr: " + film.getZanr());
        holder.tvOcjena.setText("Ocjena: " + film.getOcjena());
        holder.tvGodinaIzlaska.setText("Godina: " + film.getGodinaIzlaska());
        holder.tvTrajanje.setText("Trajanje: " + film.getTrajanje());

        SharedPreferences ratingPreferences = holder.itemView.getContext()
                .getSharedPreferences("OcjeneFilmova", android.content.Context.MODE_PRIVATE);

        float sacuvanaOcjena = ratingPreferences.getFloat(film.getNaslov(), 0.0f);
        film.setTvojaOcjena(sacuvanaOcjena);

        if (sacuvanaOcjena > 0) {
            holder.tvTvojaOcjena.setText("Tvoja ocjena: " + String.format(Locale.US, "%.1f", sacuvanaOcjena));
        } else {
            holder.tvTvojaOcjena.setText("Tvoja ocjena: Nije ocijenjen");
        }

        SharedPreferences favoritPreferences = holder.itemView.getContext()
                .getSharedPreferences("FavoritiFilmova", android.content.Context.MODE_PRIVATE);

        boolean jeFavorit = favoritPreferences.getBoolean(film.getNaslov(), false);
        film.setFavorit(jeFavorit);

        if (jeFavorit) {
            holder.btnFavorit.setImageResource(R.drawable.ic_star_filled);
        } else {
            holder.btnFavorit.setImageResource(R.drawable.ic_star_outline);
        }

        holder.btnFavorit.setOnClickListener(v -> {
            boolean noviStatus = !favoritPreferences.getBoolean(film.getNaslov(), false);

            SharedPreferences.Editor editor = favoritPreferences.edit();
            editor.putBoolean(film.getNaslov(), noviStatus);
            editor.apply();

            film.setFavorit(noviStatus);

            if (noviStatus) {
                holder.btnFavorit.setImageResource(R.drawable.ic_star_filled);
            } else {
                holder.btnFavorit.setImageResource(R.drawable.ic_star_outline);
            }
        });

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetaljiFilmaActivity.class);
            intent.putExtra("film", film);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listaFilmova.size();
    }

    public void filter(String upit, String zanr) {
        listaFilmova.clear();
        for (Film film : listaFilmovaOriginal) {
            boolean nazivOdgovara = upit.isEmpty() || film.getNaslov().toLowerCase().startsWith(upit.toLowerCase().trim());
            boolean zanrOdgovara = zanr.equals("Svi žanrovi") || film.getZanr().equals(zanr);

            if (nazivOdgovara && zanrOdgovara) {
                listaFilmova.add(film);
            }
        }
        notifyDataSetChanged();
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder {

        ImageView ivSlikaFilma;
        ImageButton btnFavorit;
        TextView tvNaslov, tvZanr, tvOcjena, tvGodinaIzlaska, tvTrajanje, tvTvojaOcjena;

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);

            ivSlikaFilma = itemView.findViewById(R.id.ivSlikaFilma);
            btnFavorit = itemView.findViewById(R.id.btnFavorit);
            tvNaslov = itemView.findViewById(R.id.tvNaslov);
            tvZanr = itemView.findViewById(R.id.tvZanr);
            tvOcjena = itemView.findViewById(R.id.tvOcjena);
            tvGodinaIzlaska = itemView.findViewById(R.id.tvGodinaIzlaska);
            tvTrajanje = itemView.findViewById(R.id.tvTrajanje);
            tvTvojaOcjena = itemView.findViewById(R.id.tvTvojaOcjena);
        }
    }
}