package com.canberkduman.proje.model;

import com.canberkduman.proje.enums.Cinsiyet;
import jakarta.persistence.*;

@Entity
@Table(name = "personel")
public class Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adi")
    private String adi;

    @Column(name = "soyadi")
    private String soyadi;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "cinsiyet")
    private Cinsiyet cinsiyet;

    @ManyToOne()
    @JoinColumn(name = "sirket_id")
    private Sirket bagliOlduguSirket;


    public Personel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "Personel{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", soyadi='" + soyadi + '\'' +
                ", cinsiyet=" + cinsiyet +
                ", bagliOlduguSirket=" + bagliOlduguSirket +
                '}';
    }
}
