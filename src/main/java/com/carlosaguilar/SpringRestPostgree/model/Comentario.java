package com.carlosaguilar.SpringRestPostgree.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Comentarios")

public class Comentario {

    /**
     * Id de comentario
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Descripcion de un comentario
     */
    @Column(name = "description", length = 256)
    private String description;



    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonIgnoreProperties("comentarios")
    @JoinColumn(name = "places", nullable = true)
    Lugar lugar;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonIgnoreProperties("comentarios")
    @JoinColumn(name = "Usuarios", nullable = true)
    Usuario usuario;

    public Comentario() {
    }

    public Comentario(Long id, String description, Lugar lugar, Usuario usuario) {
        this.id = id;
        this.description = description;
        this.lugar = lugar;
        this.usuario = usuario;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", description='" + description + '\'' +

                '}';
    }
}
