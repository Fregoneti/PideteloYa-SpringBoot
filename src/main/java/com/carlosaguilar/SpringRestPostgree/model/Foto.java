package com.carlosaguilar.SpringRestPostgree.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "Fotos")
public class Foto {
    /**
     * Id de foto
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Url de la foto
     */
    @NotBlank
    @Column(name = "url", length = 256)
    private String url;

    /**
     * Lugar que esta asociada al lugar
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "place", nullable = true)
    Lugar lugar;


    public Foto() {

    }

    public Foto(Long id, @NotBlank String url) {
        this.id = id;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "Foto{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
