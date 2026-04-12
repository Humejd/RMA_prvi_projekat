package com.example.miniimdb;

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

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvFilmovi;
    private List<Film> listaFilmova;
    private FilmAdapter filmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvFilmovi = findViewById(R.id.rvFilmovi);
        rvFilmovi.setLayoutManager(new LinearLayoutManager(this));

        listaFilmova = new ArrayList<>();

        List<Glumac> glumciShawshank = new ArrayList<>();
        glumciShawshank.add(new Glumac(R.drawable.tim_robbins, "Tim Robbins"));
        glumciShawshank.add(new Glumac(R.drawable.morgan_freeman, "Morgan Freeman"));
        glumciShawshank.add(new Glumac(R.drawable.bob_gunton, "Bob Gunton"));
        glumciShawshank.add(new Glumac(R.drawable.william_sadler, "William Sadler"));
        glumciShawshank.add(new Glumac(R.drawable.clancy_brown, "Clancy Brown"));

        listaFilmova.add(new Film(
                R.drawable.shaw,
                "The Shawshank Redemption",
                "Drama",
                "9.3",
                "Priča o nadi, prijateljstvu i opstanku u zatvoru.",
                glumciShawshank
        ));

        List<Glumac> glumciPianist = new ArrayList<>();
        glumciPianist.add(new Glumac(R.drawable.adrien_brody, "Adrien Brody"));
        glumciPianist.add(new Glumac(R.drawable.thomas_kretschmann, "Thomas Kretschmann"));
        glumciPianist.add(new Glumac(R.drawable.frank_finlay, "Frank Finlay"));
        glumciPianist.add(new Glumac(R.drawable.emilia_fox, "Emilia Fox"));
        glumciPianist.add(new Glumac(R.drawable.ed_stoppard, "Ed Stoppard"));

        listaFilmova.add(new Film(
                R.drawable.pianist,
                "The Pianist",
                "Drama",
                "8.5",
                "Priča o pijanisti koji pokušava preživjeti strahote Drugog svjetskog rata.",
                glumciPianist
        ));

        List<Glumac> glumciDarkKnight = new ArrayList<>();
        glumciDarkKnight.add(new Glumac(R.drawable.christian_bale, "Christian Bale"));
        glumciDarkKnight.add(new Glumac(R.drawable.heath_ledger, "Heath Ledger"));
        glumciDarkKnight.add(new Glumac(R.drawable.aaron_eckhart, "Aaron Eckhart"));
        glumciDarkKnight.add(new Glumac(R.drawable.michael_caine, "Michael Caine"));
        glumciDarkKnight.add(new Glumac(R.drawable.gary_oldman, "Gary Oldman"));

        listaFilmova.add(new Film(
                R.drawable.knight,
                "The Dark Knight",
                "Akcija",
                "9.0",
                "Batman se suočava s Jokerom koji unosi haos u Gotham.",
                glumciDarkKnight
        ));

        listaFilmova.add(new Film(R.drawable.seven, "Se7en", "Triler", "8.6", "Dvojica detektiva istražuju niz jezivih zločina povezanih sa sedam smrtnih grijeha.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.inception, "Inception", "Sci-Fi", "8.8", "Tim ulazi u snove kako bi ubacio ideju u nečiji um.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.departed, "The Departed", "Krimi", "8.5", "Policajac i doušnik pokušavaju otkriti identitet jedan drugog unutar opasne kriminalne mreže.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.forrest, "Forrest Gump", "Drama", "8.8", "Životna priča jednostavnog čovjeka kroz važne događaje.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.interstellar, "Interstellar", "Sci-Fi", "8.7", "Putovanje kroz svemir u potrazi za novim domom čovječanstva.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.matrix, "The Matrix", "Sci-Fi", "8.7", "Haker otkriva pravu prirodu stvarnosti.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.gladiator, "Gladiator", "Historijski", "8.5", "Rimski general traži pravdu nakon izdaje.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.momento, "Memento", "Misterija", "8.4", "Čovjek s gubitkom kratkotrajnog pamćenja pokušava otkriti istinu o ubistvu svoje supruge.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.avatar, "Avatar", "Sci-Fi", "7.8", "Čovjek ulazi u svijet Pandore i sukobljava se sa sopstvenom stranom.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.whiplash, "Whiplash", "Drama", "8.5", "Mladi bubnjar prolazi kroz brutalnu muzičku obuku.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.joker, "Joker", "Drama", "8.4", "Priča o psihološkom padu čovjeka odbačenog od društva.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.parasite, "Parasite", "Triler", "8.5", "Društvena satira o dvije porodice iz različitih slojeva.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.prestige, "The Prestige", "Misterija", "8.5", "Rivalstvo dvojice mađioničara postaje opasna opsesija.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.django, "Django Unchained", "Vestern", "8.4", "Oslobođeni rob kreće u potragu za svojom ženom.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.lion, "The Lion King", "Animacija", "8.5", "Mladi lav uči šta znači odgovornost i naslijeđe.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.shutter, "Shutter Island", "Triler", "8.2", "Istraga na izolovanom ostrvu otkriva mračnu istinu.", new ArrayList<>()));
        listaFilmova.add(new Film(R.drawable.mile, "The Green Mile", "Drama", "8.6", "Neobičan zatvorenik mijenja živote ljudi oko sebe.", new ArrayList<>()));

        filmAdapter = new FilmAdapter(listaFilmova);
        rvFilmovi.setAdapter(filmAdapter);
    }
}