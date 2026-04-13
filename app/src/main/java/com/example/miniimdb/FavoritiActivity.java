package com.example.miniimdb;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FavoritiActivity extends AppCompatActivity {

    private RecyclerView rvFavoriti;
    private FilmAdapter filmAdapter;
    private List<Film> listaFavorita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favoriti);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvFavoriti = findViewById(R.id.rvFavoriti);
        rvFavoriti.setLayoutManager(new LinearLayoutManager(this));

        listaFavorita = new ArrayList<>();
        ucitajFavorite();

        filmAdapter = new FilmAdapter(listaFavorita);
        rvFavoriti.setAdapter(filmAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ucitajFavorite();
        filmAdapter.notifyDataSetChanged();
    }

    private void ucitajFavorite() {
        listaFavorita.clear();

        SharedPreferences preferences = getSharedPreferences("FavoritiFilmova", MODE_PRIVATE);

        if (MainActivity.listaFilmova != null) {
            for (Film film : MainActivity.listaFilmova) {
                boolean jeFavorit = preferences.getBoolean(film.getNaslov(), false);
                film.setFavorit(jeFavorit);

                if (jeFavorit) {
                    listaFavorita.add(film);
                }
            }
        }
    }
}