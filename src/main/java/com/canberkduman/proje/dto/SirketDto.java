package com.canberkduman.proje.dto;

public class SirketDto {

    private String adi;

    private String adres;

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "SirketDto{" +
                "adi='" + adi + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
