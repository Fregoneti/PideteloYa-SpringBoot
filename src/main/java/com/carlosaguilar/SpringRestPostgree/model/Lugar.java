package com.carlosaguilar.SpringRestPostgree.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


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

    @OneToMany(mappedBy = "lugar")
    @JsonIgnoreProperties("lugar")
    List<Comentario> comentarios;

    @OneToMany(mappedBy = "lugar")
    @JsonIgnoreProperties("lugar")
    List<Foto> fotos;


    public Lugar(Long id, @NotBlank String name, String phone, String adress) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        // this.comentario = comentario;
    }

    public Lugar() {

    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
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


    @Override
    public String toString() {
        return "Lugar{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
