package com.carlosaguilar.SpringRestPostgree.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;


@Entity
@Table(name = "Lugares")
public class Lugar {
    /**
     * Id de lugar
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nombre del lugar
     */
    @NotBlank
    @Column(name = "name", length = 256)
    private String name;
    /**
     * Telefono del lugar
     */
    @Column(name = "phone", length = 9)
    private String phone;
    /**
     * Direccion del lugar
     */
    @Column(name = "adress", length = 256)
    private String adress;


    /**
     * Lista de comentarios
     */
    @JsonIgnoreProperties(value = {"placesComments"}, allowSetters = true)
    @ManyToMany(mappedBy = "placesComments", cascade = {CascadeType.MERGE})
    private List<Comentario> comments;





    public Lugar(Long id, @NotBlank String name, String phone, String adress) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.adress = adress;
       // this.comentario = comentario;
    }

    public Lugar() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Comentario> getComments() {
        return comments;
    }

    public void setComments(List<Comentario> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
