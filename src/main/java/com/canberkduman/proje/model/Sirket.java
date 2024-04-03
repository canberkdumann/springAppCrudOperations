package com.canberkduman.proje.model;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "sirket")
public class Sirket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adi")
    private String adi;
    
    @Column(name = "adres")
    private String adres;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bagliOlduguSirket")
    private List<Personel> personelList = new LinkedList<>();

    public Sirket() {
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public List<Personel> getPersonelList() {
        return personelList;
    }

    public void setPersonelList(List<Personel> personelList) {
        this.personelList = personelList;
    }

    @Override
    public String toString() {
        return "Sirket{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", adres='" + adres + '\'' +
                ", personelList='" + personelList + '\'' +
                '}';
    }
}
