package com.example.miniimdb;

import java.io.Serializable;
import java.util.List;

public class Film implements Serializable {

    private int slikaID;
    private String naslov;
    private String zanr;
    private String ocjena;
    private String godinaIzlaska;
    private String trajanje;
    private String opis;
    private List<Glumac> glumci;
    private float tvojaOcjena;
    private boolean favorit;

    public Film(int slikaID, String naslov, String zanr, String ocjena, String godinaIzlaska, String trajanje, String opis, List<Glumac> glumci) {
        this.slikaID = slikaID;
        this.naslov = naslov;
        this.zanr = zanr;
        this.ocjena = ocjena;
        this.godinaIzlaska = godinaIzlaska;
        this.trajanje = trajanje;
        this.opis = opis;
        this.glumci = glumci;
        this.tvojaOcjena = 0.0f;
        this.favorit = false;
    }

    public int getSlikaID() {
        return slikaID;
    }

    public String getNaslov() {
        return naslov;
    }

    public String getZanr() {
        return zanr;
    }

    public String getOcjena() {
        return ocjena;
    }

    public String getGodinaIzlaska() {
        return godinaIzlaska;
    }

    public String getTrajanje() {
        return trajanje;
    }

    public String getOpis() {
        return opis;
    }

    public List<Glumac> getGlumci() {
        return glumci;
    }

    public float getTvojaOcjena() {
        return tvojaOcjena;
    }

    public void setTvojaOcjena(float tvojaOcjena) {
        this.tvojaOcjena = tvojaOcjena;
    }

    public boolean isFavorit() {
        return favorit;
    }

    public void setFavorit(boolean favorit) {
        this.favorit = favorit;
    }
}