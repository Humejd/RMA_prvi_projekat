package com.example.miniimdb;

import java.io.Serializable;

public class Glumac implements Serializable {

    private int slikaID;
    private String imePrezime;

    public Glumac(int slikaID, String imePrezime) {
        this.slikaID = slikaID;
        this.imePrezime = imePrezime;
    }

    public int getSlikaID() {
        return slikaID;
    }

    public String getImePrezime() {
        return imePrezime;
    }
}
