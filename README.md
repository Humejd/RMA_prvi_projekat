Mini IMDB

Mini IMDB je Android aplikacija razvijena u Android Studiju koristeći Java programski jezik. Aplikacija omogućava pregled liste filmova, prikaz detalja o filmu, ocjenjivanje filmova, dodavanje filmova u favorite i pregled omiljenih filmova.

Funkcionalnosti
Aplikacija sadrži sljedeće funkcionalnosti:
•	prikaz liste od 20 filmova na početnom ekranu 
•	prikaz postera, naslova, žanra, IMDb ocjene, godine izlaska i trajanja filma 
•	pretragu filmova po naslovu 
•	filtriranje filmova po žanru 
•	otvaranje detalja filma klikom na stavku iz liste 
•	prikaz detalja filma: slika, naslov, žanr, ocjena, opis i glumci 
•	prikaz 5 glumaca sa slikama i imenima 
•	uvećanje slike glumca klikom na sliku 
•	korisničko ocjenjivanje filma 
•	prikaz korisnikove ocjene na detaljima i početnoj listi 
•	označavanje filmova kao favorita 
•	poseban ekran za prikaz omiljenih filmova 
•	tamna tema aplikacije 
•	poboljšan korisnički interfejs sa Toolbar/AppBar komponentama, boljim razmacima i bojama 

Tehnologije
Projekt je razvijen koristeći:
•	Java 
•	Android Studio 
•	RecyclerView 
•	CardView 
•	SharedPreferences 
•	XML layout fajlove 
•	Material Design komponente 

Struktura projekta
Glavni fajlovi projekta su:
•	MainActivity.java
Glavni ekran aplikacije. Učitava filmove, povezuje RecyclerView, omogućava pretragu, filtriranje i otvaranje ekrana favorita. 
•	Film.java
Model klasa za film. Sadrži podatke o filmu kao što su slika, naslov, žanr, ocjena, godina izlaska, trajanje, opis, lista glumaca, korisnikova ocjena i status favorita. 
•	Glumac.java
Model klasa za glumca. Sadrži sliku i ime glumca. 
•	FilmAdapter.java
Adapter za RecyclerView. Prikazuje podatke o filmovima na početnom ekranu i omogućava otvaranje detalja filma. 
•	DetaljiFilmaActivity.java
Aktivnost za detaljan prikaz filma. Omogućava pregled detalja, ocjenjivanje filma i dodavanje u favorite. 
•	FavoritiActivity.java
Aktivnost za prikaz filmova koji su označeni kao favoriti. 

Layout fajlovi
Layout fajlovi projekta su:
•	activity_main.xml
Glavni ekran sa toolbarom, pretragom, spinnerom za žanr, dugmetom za favorite i listom filmova. 
•	stavka_film.xml
Layout jedne stavke filma na početnoj listi. 
•	activity_detalji_filma.xml
Layout detalja filma. 
•	activity_favoriti.xml
Layout ekrana za favorite. 
•	uvecana_slika_glumca.xml
Layout za prikaz uvećane slike glumca u dialogu. 

Čuvanje podataka
Aplikacija koristi SharedPreferences za lokalno čuvanje podataka:
•	korisnikove ocjene filmova 
•	statusa favorita za svaki film 
Na taj način se ocjene i favoriti zadržavaju i nakon prelaska između ekrana.

Način rada aplikacije
1.	Korisnik na početnom ekranu vidi listu filmova. 
2.	Korisnik može pretraživati filmove po naslovu. 
3.	Korisnik može filtrirati filmove po žanru. 
4.	Klikom na film otvara se ekran detalja filma. 
5.	Na detaljima korisnik može pregledati opis filma, vidjeti glumce, ocijeniti film i označiti film kao favorit. 
6.	Korisnik može otvoriti poseban ekran favorita i pregledati omiljene filmove.
   
Pokretanje projekta
Za pokretanje projekta potrebno je:
1.	otvoriti projekat u Android Studiju 
2.	sačekati da se učitaju zavisnosti projekta 
3.	pokrenuti aplikaciju na emulatoru ili fizičkom Android uređaju
   
Cilj projekta
Cilj projekta je izrada jednostavne filmske Android aplikacije koja demonstrira upotrebu osnovnih Android komponenti i funkcionalnosti, kao što su:
•	aktivnosti 
•	RecyclerView 
•	adapteri 
•	modeli podataka 
•	rad sa XML layoutima 
•	rad sa lokalnim spremanjem podataka 
•	osnovni UI dizajn i stiliziranje 

Autor
Humejd Oruč

