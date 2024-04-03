package com.canberkduman.proje.dto;

import com.canberkduman.proje.enums.Cinsiyet;
import com.canberkduman.proje.model.Sirket;

public class PersonelDto {

    private String adi;

    private String soyadi;

    private Cinsiyet cinsiyet;

    private Sirket bagliOlduguSirket;

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public Cinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Cinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public Sirket getBagliOlduguSirket() {
        return bagliOlduguSirket;
    }

    public void setBagliOlduguSirket(Sirket bagliOlduguSirket) {
        this.bagliOlduguSirket = bagliOlduguSirket;
    }

    @Override
    public String toString() {
        return "PersonelDto{" +
                "adi='" + adi + '\'' +
                ", soyadi='" + soyadi + '\'' +
                ", cinsiyet=" + cinsiyet +
                ", bagliOlduguSirket=" + bagliOlduguSirket +
                '}';
    }
}
