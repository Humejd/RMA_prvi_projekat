package com.example.miniimdb;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    private List<Film> listaFilmova;

    public FilmAdapter(List<Film> listaFilmova) {
        this.listaFilmova = listaFilmova;
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

    public static class FilmViewHolder extends RecyclerView.ViewHolder {

        ImageView ivSlikaFilma;
        TextView tvNaslov, tvZanr, tvOcjena;

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);

            ivSlikaFilma = itemView.findViewById(R.id.ivSlikaFilma);
            tvNaslov = itemView.findViewById(R.id.tvNaslov);
            tvZanr = itemView.findViewById(R.id.tvZanr);
            tvOcjena = itemView.findViewById(R.id.tvOcjena);
        }
    }
}