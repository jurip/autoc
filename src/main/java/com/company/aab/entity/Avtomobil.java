package com.company.aab.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "AVTOMOBIL", indexes = {
        @Index(name = "IDX_AVTOMOBIL_ZAYAVKA", columnList = "ZAYAVKA_ID")
})
@Entity
public class Avtomobil {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Composition
    @OneToMany(mappedBy = "avtomobil")
    private List<Foto> fotos;

    @Column(name = "NOMER")
    private String nomer;

    @Column(name = "MARKA")
    private String marka;

    @JoinColumn(name = "ZAYAVKA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Zayavka zayavka;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public Zayavka getZayavka() {
        return zayavka;
    }

    public void setZayavka(Zayavka zayavka) {
        this.zayavka = zayavka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
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