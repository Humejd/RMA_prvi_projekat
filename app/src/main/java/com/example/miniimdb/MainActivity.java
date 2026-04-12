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

        List<Glumac> glumciSe7en = new ArrayList<>();
        glumciSe7en.add(new Glumac(R.drawable.brad_pitt, "Brad Pitt"));
        glumciSe7en.add(new Glumac(R.drawable.morgan_freeman, "Morgan Freeman"));
        glumciSe7en.add(new Glumac(R.drawable.gwyneth_paltrow, "Gwyneth Paltrow"));
        glumciSe7en.add(new Glumac(R.drawable.kevin_spacey, "Kevin Spacey"));
        glumciSe7en.add(new Glumac(R.drawable.r_lee_ermey, "R. Lee Ermey"));

        listaFilmova.add(new Film(
                R.drawable.seven,
                "Se7en",
                "Triler",
                "8.6",
                "Dvojica detektiva istražuju niz jezivih zločina povezanih sa sedam smrtnih grijeha.",
                glumciSe7en
        ));

        List<Glumac> glumciInception = new ArrayList<>();
        glumciInception.add(new Glumac(R.drawable.leonardo_dicaprio, "Leonardo DiCaprio"));
        glumciInception.add(new Glumac(R.drawable.joseph_gordon_levitt, "Joseph Gordon-Levitt"));
        glumciInception.add(new Glumac(R.drawable.elliot_page, "Elliot Page"));
        glumciInception.add(new Glumac(R.drawable.tom_hardy, "Tom Hardy"));
        glumciInception.add(new Glumac(R.drawable.ken_watanabe, "Ken Watanabe"));

        listaFilmova.add(new Film(
                R.drawable.inception,
                "Inception",
                "Sci-Fi",
                "8.8",
                "Tim ulazi u snove kako bi ubacio ideju u nečiji um.",
                glumciInception
        ));

        List<Glumac> glumciDeparted = new ArrayList<>();
        glumciDeparted.add(new Glumac(R.drawable.leonardo_dicaprio, "Leonardo DiCaprio"));
        glumciDeparted.add(new Glumac(R.drawable.matt_damon, "Matt Damon"));
        glumciDeparted.add(new Glumac(R.drawable.jack_nicholson, "Jack Nicholson"));
        glumciDeparted.add(new Glumac(R.drawable.mark_wahlberg, "Mark Wahlberg"));
        glumciDeparted.add(new Glumac(R.drawable.martin_sheen, "Martin Sheen"));

        listaFilmova.add(new Film(
                R.drawable.departed,
                "The Departed",
                "Krimi",
                "8.5",
                "Policajac i doušnik pokušavaju otkriti identitet jedan drugog unutar opasne kriminalne mreže.",
                glumciDeparted
        ));

        List<Glumac> glumciForrest = new ArrayList<>();
        glumciForrest.add(new Glumac(R.drawable.tom_hanks, "Tom Hanks"));
        glumciForrest.add(new Glumac(R.drawable.robin_wright, "Robin Wright"));
        glumciForrest.add(new Glumac(R.drawable.gary_sinise, "Gary Sinise"));
        glumciForrest.add(new Glumac(R.drawable.sally_field, "Sally Field"));
        glumciForrest.add(new Glumac(R.drawable.mykelti_williamson, "Mykelti Williamson"));

        listaFilmova.add(new Film(
                R.drawable.forrest,
                "Forrest Gump",
                "Drama",
                "8.8",
                "Životna priča jednostavnog čovjeka kroz važne događaje.",
                glumciForrest
        ));

        List<Glumac> glumciInterstellar = new ArrayList<>();
        glumciInterstellar.add(new Glumac(R.drawable.matthew_mcconaughey, "Matthew McConaughey"));
        glumciInterstellar.add(new Glumac(R.drawable.anne_hathaway, "Anne Hathaway"));
        glumciInterstellar.add(new Glumac(R.drawable.jessica_chastain, "Jessica Chastain"));
        glumciInterstellar.add(new Glumac(R.drawable.michael_caine, "Michael Caine"));
        glumciInterstellar.add(new Glumac(R.drawable.mackenzie_foy, "Mackenzie Foy"));

        listaFilmova.add(new Film(
                R.drawable.interstellar,
                "Interstellar",
                "Sci-Fi",
                "8.7",
                "Putovanje kroz svemir u potrazi za novim domom čovječanstva.",
                glumciInterstellar
        ));

        List<Glumac> glumciMatrix = new ArrayList<>();
        glumciMatrix.add(new Glumac(R.drawable.keanu_reeves, "Keanu Reeves"));
        glumciMatrix.add(new Glumac(R.drawable.laurence_fishburne, "Laurence Fishburne"));
        glumciMatrix.add(new Glumac(R.drawable.carrie_anne_moss, "Carrie-Anne Moss"));
        glumciMatrix.add(new Glumac(R.drawable.hugo_weaving, "Hugo Weaving"));
        glumciMatrix.add(new Glumac(R.drawable.joe_pantoliano, "Joe Pantoliano"));

        listaFilmova.add(new Film(
                R.drawable.matrix,
                "The Matrix",
                "Sci-Fi",
                "8.7",
                "Haker otkriva pravu prirodu stvarnosti.",
                glumciMatrix
        ));

        List<Glumac> glumciGladiator = new ArrayList<>();
        glumciGladiator.add(new Glumac(R.drawable.russell_crowe, "Russell Crowe"));
        glumciGladiator.add(new Glumac(R.drawable.joaquin_phoenix, "Joaquin Phoenix"));
        glumciGladiator.add(new Glumac(R.drawable.connie_nielsen, "Connie Nielsen"));
        glumciGladiator.add(new Glumac(R.drawable.oliver_reed, "Oliver Reed"));
        glumciGladiator.add(new Glumac(R.drawable.derek_jacobi, "Derek Jacobi"));

        listaFilmova.add(new Film(
                R.drawable.gladiator,
                "Gladiator",
                "Historijski",
                "8.5",
                "Rimski general traži pravdu nakon izdaje.",
                glumciGladiator
        ));

        List<Glumac> glumciAvatar = new ArrayList<>();
        glumciAvatar.add(new Glumac(R.drawable.sam_worthington, "Sam Worthington"));
        glumciAvatar.add(new Glumac(R.drawable.zoe_saldana, "Zoe Saldana"));
        glumciAvatar.add(new Glumac(R.drawable.sigourney_weaver, "Sigourney Weaver"));
        glumciAvatar.add(new Glumac(R.drawable.stephen_lang, "Stephen Lang"));
        glumciAvatar.add(new Glumac(R.drawable.giovanni_ribisi, "Giovanni Ribisi"));

        listaFilmova.add(new Film(
                R.drawable.avatar,
                "Avatar",
                "Sci-Fi",
                "7.8",
                "Čovjek ulazi u svijet Pandore i sukobljava se sa sopstvenom stranom.",
                glumciAvatar
        ));


        List<Glumac> glumciBatmanBegins = new ArrayList<>();
        glumciBatmanBegins.add(new Glumac(R.drawable.christian_bale, "Christian Bale"));
        glumciBatmanBegins.add(new Glumac(R.drawable.michael_caine, "Michael Caine"));
        glumciBatmanBegins.add(new Glumac(R.drawable.gary_oldman, "Gary Oldman"));
        glumciBatmanBegins.add(new Glumac(R.drawable.liam_neeson, "Liam Neeson"));
        glumciBatmanBegins.add(new Glumac(R.drawable.katie_holmes, "Katie Holmes"));

        listaFilmova.add(new Film(
                R.drawable.batman_begins,
                "Batman Begins",
                "Akcija",
                "8.2",
                "Priča o nastanku Batmana i njegovoj borbi protiv kriminala u Gothamu.",
                glumciBatmanBegins
        ));

        List<Glumac> glumciDarkKnightRises = new ArrayList<>();
        glumciDarkKnightRises.add(new Glumac(R.drawable.christian_bale, "Christian Bale"));
        glumciDarkKnightRises.add(new Glumac(R.drawable.michael_caine, "Michael Caine"));
        glumciDarkKnightRises.add(new Glumac(R.drawable.gary_oldman, "Gary Oldman"));
        glumciDarkKnightRises.add(new Glumac(R.drawable.tom_hardy, "Tom Hardy"));
        glumciDarkKnightRises.add(new Glumac(R.drawable.anne_hathaway, "Anne Hathaway"));

        listaFilmova.add(new Film(
                R.drawable.dark_knight_rises,
                "The Dark Knight Rises",
                "Akcija",
                "8.4",
                "Batman se vraća kako bi spasio Gotham od nove prijetnje.",
                glumciDarkKnightRises
        ));

        List<Glumac> glumciCatchMe = new ArrayList<>();
        glumciCatchMe.add(new Glumac(R.drawable.leonardo_dicaprio, "Leonardo DiCaprio"));
        glumciCatchMe.add(new Glumac(R.drawable.tom_hanks, "Tom Hanks"));
        glumciCatchMe.add(new Glumac(R.drawable.christopher_walken, "Christopher Walken"));
        glumciCatchMe.add(new Glumac(R.drawable.martin_sheen, "Martin Sheen"));
        glumciCatchMe.add(new Glumac(R.drawable.amy_adams, "Amy Adams"));

        listaFilmova.add(new Film(
                R.drawable.catch_me_if_you_can,
                "Catch Me If You Can",
                "Krimi",
                "8.1",
                "Mladi prevarant godinama izbjegava upornog FBI agenta.",
                glumciCatchMe
        ));

        List<Glumac> glumciRevenant = new ArrayList<>();
        glumciRevenant.add(new Glumac(R.drawable.leonardo_dicaprio, "Leonardo DiCaprio"));
        glumciRevenant.add(new Glumac(R.drawable.tom_hardy, "Tom Hardy"));
        glumciRevenant.add(new Glumac(R.drawable.domhnall_gleeson, "Domhnall Gleeson"));
        glumciRevenant.add(new Glumac(R.drawable.will_poulter, "Will Poulter"));
        glumciRevenant.add(new Glumac(R.drawable.forrest_goodluck, "Forrest Goodluck"));

        listaFilmova.add(new Film(
                R.drawable.revenant,
                "The Revenant",
                "Drama",
                "8.0",
                "Lovac na krzno kreće u brutalnu borbu za preživljavanje i osvetu.",
                glumciRevenant
        ));

        List<Glumac> glumciBucketList = new ArrayList<>();
        glumciBucketList.add(new Glumac(R.drawable.morgan_freeman, "Morgan Freeman"));
        glumciBucketList.add(new Glumac(R.drawable.jack_nicholson, "Jack Nicholson"));
        glumciBucketList.add(new Glumac(R.drawable.sean_hayes, "Sean Hayes"));
        glumciBucketList.add(new Glumac(R.drawable.beverly_todd, "Beverly Todd"));
        glumciBucketList.add(new Glumac(R.drawable.rob_morrow, "Rob Morrow"));

        listaFilmova.add(new Film(
                R.drawable.bucket_list,
                "The Bucket List",
                "Drama",
                "7.4",
                "Dvojica teško bolesnih muškaraca odlučuju ispuniti svoje životne želje.",
                glumciBucketList
        ));

        List<Glumac> glumciPrestige = new ArrayList<>();
        glumciPrestige.add(new Glumac(R.drawable.christian_bale, "Christian Bale"));
        glumciPrestige.add(new Glumac(R.drawable.hugh_jackman, "Hugh Jackman"));
        glumciPrestige.add(new Glumac(R.drawable.scarlett_johansson, "Scarlett Johansson"));
        glumciPrestige.add(new Glumac(R.drawable.michael_caine, "Michael Caine"));
        glumciPrestige.add(new Glumac(R.drawable.rebecca_hall, "Rebecca Hall"));

        listaFilmova.add(new Film(
                R.drawable.prestige,
                "The Prestige",
                "Misterija",
                "8.5",
                "Rivalstvo dvojice mađioničara postaje opasna opsesija.",
                glumciPrestige
        ));

        List<Glumac> glumciMemento = new ArrayList<>();
        glumciMemento.add(new Glumac(R.drawable.guy_pearce, "Guy Pearce"));
        glumciMemento.add(new Glumac(R.drawable.carrie_anne_moss, "Carrie-Anne Moss"));
        glumciMemento.add(new Glumac(R.drawable.joe_pantoliano, "Joe Pantoliano"));
        glumciMemento.add(new Glumac(R.drawable.mark_boone_junior, "Mark Boone Junior"));
        glumciMemento.add(new Glumac(R.drawable.stephen_tobolowsky, "Stephen Tobolowsky"));

        listaFilmova.add(new Film(
                R.drawable.momento,
                "Memento",
                "Misterija",
                "8.4",
                "Čovjek s gubitkom kratkotrajnog pamćenja pokušava otkriti istinu o ubistvu svoje supruge.",
                glumciMemento
        ));

        List<Glumac> glumciShutter = new ArrayList<>();
        glumciShutter.add(new Glumac(R.drawable.leonardo_dicaprio, "Leonardo DiCaprio"));
        glumciShutter.add(new Glumac(R.drawable.mark_ruffalo, "Mark Ruffalo"));
        glumciShutter.add(new Glumac(R.drawable.ben_kingsley, "Ben Kingsley"));
        glumciShutter.add(new Glumac(R.drawable.michelle_williams, "Michelle Williams"));
        glumciShutter.add(new Glumac(R.drawable.max_von_sydow, "Max von Sydow"));

        listaFilmova.add(new Film(
                R.drawable.shutter,
                "Shutter Island",
                "Triler",
                "8.2",
                "Istraga na izolovanom ostrvu otkriva mračnu istinu.",
                glumciShutter
        ));

        List<Glumac> glumciJoker = new ArrayList<>();
        glumciJoker.add(new Glumac(R.drawable.joaquin_phoenix, "Joaquin Phoenix"));
        glumciJoker.add(new Glumac(R.drawable.robert_de_niro, "Robert De Niro"));
        glumciJoker.add(new Glumac(R.drawable.zazie_beetz, "Zazie Beetz"));
        glumciJoker.add(new Glumac(R.drawable.frances_conroy, "Frances Conroy"));
        glumciJoker.add(new Glumac(R.drawable.brett_cullen, "Brett Cullen"));

        listaFilmova.add(new Film(
                R.drawable.joker,
                "Joker",
                "Drama",
                "8.4",
                "Priča o psihološkom padu čovjeka odbačenog od društva.",
                glumciJoker
        ));

        filmAdapter = new FilmAdapter(listaFilmova);
        rvFilmovi.setAdapter(filmAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (listaFilmova != null) {
            for (Film film : listaFilmova) {
                float ocjena = getSharedPreferences("OcjeneFilmova", MODE_PRIVATE)
                        .getFloat(film.getNaslov(), 0.0f);
                film.setTvojaOcjena(ocjena);
            }

            if (filmAdapter != null) {
                filmAdapter.notifyDataSetChanged();
            }
        }
    }
}