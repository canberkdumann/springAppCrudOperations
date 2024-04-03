package com.canberkduman.proje.enums;

public enum Cinsiyet {

    KADIN(0, "Kadın"),
    ERKEK(1, "Erkek");
    private final int value;
    private final String aciklama;

    Cinsiyet(int value, String aciklama) {
        this.value = value;
        this.aciklama = aciklama;
    }

    public int getValue() {
        return value;
    }

    public String getAciklama() {
        return aciklama;
    }
}
