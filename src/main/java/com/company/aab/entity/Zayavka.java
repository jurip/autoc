package com.company.aab.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.data.impl.lazyloading.NotInstantiatedList;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "ZAYAVKA")
@Entity
public class Zayavka {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "NOMER")
    private String nomer;

    @Column(name = "NACHALO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nachalo;

    @Column(name = "KLIENT")
    private String klient;

    @Column(name = "ADRES")
    private String adres;

    @Column(name = "KOMMENTARIJ")
    private String kommentarij;

    @Column(name = "STATUS")
    private String status;

    @Composition
    @OneToMany(mappedBy = "zayavka")
    private List<Avtomobil> avomobili = new NotInstantiatedList<Avtomobil>();

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    public List<Avtomobil> getAvomobili() {
        return avomobili;
    }

    public void setAvomobili(List<Avtomobil> avomobili) {
        this.avomobili = avomobili;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKommentarij() {
        return kommentarij;
    }

    public void setKommentarij(String kommentarij) {
        this.kommentarij = kommentarij;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKlient() {
        return klient;
    }

    public void setKlient(String klient) {
        this.klient = klient;
    }

    public Date getNachalo() {
        return nachalo;
    }

    public void setNachalo(Date nachalo) {
        this.nachalo = nachalo;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}