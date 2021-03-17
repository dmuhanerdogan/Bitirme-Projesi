package com.example.asus.bitirmeprojesi;


public class EgzersizCesitleriYerlesim {
    private String egzersizAdi;
    private int resimID;

    public EgzersizCesitleriYerlesim(String adi, int id){
        this.setEgzersizAdi(adi);
        this.setResimID(id);
    }

    public void setEgzersizAdi(String egzersizAdi) {
        this.egzersizAdi = egzersizAdi;
    }

    public void setResimID(int resimID) {
        this.resimID = resimID;
    }

    public String getEgzersizAdi() {
        return egzersizAdi;
    }

    public int getResimID() {
        return resimID;
    }
}
