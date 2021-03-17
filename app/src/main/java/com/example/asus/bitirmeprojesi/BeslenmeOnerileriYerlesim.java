package com.example.asus.bitirmeprojesi;

public class BeslenmeOnerileriYerlesim {
    private String besinAdi;
    private int resimID2;

    public BeslenmeOnerileriYerlesim(String adi, int id){
        this.setBesinAdi(adi);
        this.setResimID2(id);
    }

    public void setBesinAdi(String besinAdi) {
        this.besinAdi = besinAdi;
    }

    public void setResimID2(int resimID2) {
        this.resimID2 = resimID2;
    }

    public String getBesinAdi() {
        return besinAdi;
    }

    public int getResimID2() {
        return resimID2;
    }
}
