package com.example.miniimdb;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class DetaljiFilmaActivity extends AppCompatActivity {

    private ImageView ivSlikaDetalji;
    private TextView tvNaslovDetalji;
    private TextView tvZanrDetalji;
    private TextView tvOcjenaDetalji;
    private TextView tvOpisDetalji;
    private TextView tvTvojaOcjenaDetalji;
    private RatingBar ratingBarFilm;
    private ImageButton btnFavoritDetalji;

    private ImageView ivGlumac1, ivGlumac2, ivGlumac3, ivGlumac4, ivGlumac5;
    private TextView tvGlumac1, tvGlumac2, tvGlumac3, tvGlumac4, tvGlumac5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalji_filma);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ivSlikaDetalji = findViewById(R.id.ivSlikaDetalji);
        tvNaslovDetalji = findViewById(R.id.tvNaslovDetalji);
        tvZanrDetalji = findViewById(R.id.tvZanrDetalji);
        tvOcjenaDetalji = findViewById(R.id.tvOcjenaDetalji);
        tvOpisDetalji = findViewById(R.id.tvOpisDetalji);
        tvTvojaOcjenaDetalji = findViewById(R.id.tvTvojaOcjenaDetalji);
        ratingBarFilm = findViewById(R.id.ratingBarFilm);
        btnFavoritDetalji = findViewById(R.id.btnFavoritDetalji);

        ratingBarFilm.post(() -> {
            float scale = 0.8f;
            ratingBarFilm.setScaleX(scale);
            ratingBarFilm.setScaleY(scale);
            ratingBarFilm.setPivotX(0f);
            ViewGroup.LayoutParams params = ratingBarFilm.getLayoutParams();
            params.width = (int) (ratingBarFilm.getWidth() / scale);
            ratingBarFilm.setLayoutParams(params);
        });

        ivGlumac1 = findViewById(R.id.ivGlumac1);
        ivGlumac2 = findViewById(R.id.ivGlumac2);
        ivGlumac3 = findViewById(R.id.ivGlumac3);
        ivGlumac4 = findViewById(R.id.ivGlumac4);
        ivGlumac5 = findViewById(R.id.ivGlumac5);

        tvGlumac1 = findViewById(R.id.tvGlumac1);
        tvGlumac2 = findViewById(R.id.tvGlumac2);
        tvGlumac3 = findViewById(R.id.tvGlumac3);
        tvGlumac4 = findViewById(R.id.tvGlumac4);
        tvGlumac5 = findViewById(R.id.tvGlumac5);

        Film film = (Film) getIntent().getSerializableExtra("film");

        if (film != null) {
            ivSlikaDetalji.setImageResource(film.getSlikaID());
            tvNaslovDetalji.setText(film.getNaslov());
            tvZanrDetalji.setText("Žanr: " + film.getZanr());
            tvOcjenaDetalji.setText("Ocjena: " + film.getOcjena());
            tvOpisDetalji.setText(film.getOpis());

            SharedPreferences favoritPreferences = getSharedPreferences("FavoritiFilmova", MODE_PRIVATE);
            boolean jeFavorit = favoritPreferences.getBoolean(film.getNaslov(), false);
            film.setFavorit(jeFavorit);

            if (jeFavorit) {
                btnFavoritDetalji.setImageResource(R.drawable.ic_star_filled);
            } else {
                btnFavoritDetalji.setImageResource(R.drawable.ic_star_outline);
            }

            btnFavoritDetalji.setOnClickListener(v -> {
                boolean noviStatus = !favoritPreferences.getBoolean(film.getNaslov(), false);

                SharedPreferences.Editor favoritEditor = favoritPreferences.edit();
                favoritEditor.putBoolean(film.getNaslov(), noviStatus);
                favoritEditor.apply();

                film.setFavorit(noviStatus);

                if (noviStatus) {
                    btnFavoritDetalji.setImageResource(R.drawable.ic_star_filled);
                } else {
                    btnFavoritDetalji.setImageResource(R.drawable.ic_star_outline);
                }
            });

            SharedPreferences preferences = getSharedPreferences("OcjeneFilmova", MODE_PRIVATE);
            float sacuvanaOcjena = preferences.getFloat(film.getNaslov(), 0.0f);
            film.setTvojaOcjena(sacuvanaOcjena);

            if (sacuvanaOcjena > 0) {
                ratingBarFilm.setRating(sacuvanaOcjena);
                tvTvojaOcjenaDetalji.setText("Tvoja ocjena: " + String.format(Locale.US, "%.1f", sacuvanaOcjena));
            } else {
                tvTvojaOcjenaDetalji.setText("Tvoja ocjena: Nije ocijenjen");
            }

            ratingBarFilm.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
                film.setTvojaOcjena(rating);
                tvTvojaOcjenaDetalji.setText("Tvoja ocjena: " + String.format(Locale.US, "%.1f", rating));

                SharedPreferences.Editor editor = preferences.edit();
                editor.putFloat(film.getNaslov(), rating);
                editor.apply();
            });

            if (film.getGlumci() != null && film.getGlumci().size() >= 5) {
                ivGlumac1.setImageResource(film.getGlumci().get(0).getSlikaID());
                tvGlumac1.setText(film.getGlumci().get(0).getImePrezime());

                ivGlumac2.setImageResource(film.getGlumci().get(1).getSlikaID());
                tvGlumac2.setText(film.getGlumci().get(1).getImePrezime());

                ivGlumac3.setImageResource(film.getGlumci().get(2).getSlikaID());
                tvGlumac3.setText(film.getGlumci().get(2).getImePrezime());

                ivGlumac4.setImageResource(film.getGlumci().get(3).getSlikaID());
                tvGlumac4.setText(film.getGlumci().get(3).getImePrezime());

                ivGlumac5.setImageResource(film.getGlumci().get(4).getSlikaID());
                tvGlumac5.setText(film.getGlumci().get(4).getImePrezime());

                ivGlumac1.setOnClickListener(v -> prikaziUvecanuSliku(film.getGlumci().get(0).getSlikaID()));
                ivGlumac2.setOnClickListener(v -> prikaziUvecanuSliku(film.getGlumci().get(1).getSlikaID()));
                ivGlumac3.setOnClickListener(v -> prikaziUvecanuSliku(film.getGlumci().get(2).getSlikaID()));
                ivGlumac4.setOnClickListener(v -> prikaziUvecanuSliku(film.getGlumci().get(3).getSlikaID()));
                ivGlumac5.setOnClickListener(v -> prikaziUvecanuSliku(film.getGlumci().get(4).getSlikaID()));
            }
        }
    }

    private void prikaziUvecanuSliku(int slikaID) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.uvecana_slika_glumca);

        ImageView ivVelikaSlikaGlumca = dialog.findViewById(R.id.ivVelikaSlikaGlumca);
        ivVelikaSlikaGlumca.setImageResource(slikaID);

        dialog.show();
    }
}