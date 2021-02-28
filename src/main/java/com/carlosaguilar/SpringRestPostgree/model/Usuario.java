package com.carlosaguilar.SpringRestPostgree.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    /**
     * Id del usuario
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Email del usuario
     */
    @NotBlank
    @Column(name = "email", length = 256)
    private String email;
    /**
     * Contraseña del usuario
     */
    @NotBlank
    @Column(name = "pass", length = 256)
    private String pass;

    /**
     * Lista de comentarios de un usuario
     */
    @JsonIgnoreProperties(value = {"users"}, allowSetters = true)
    @ManyToMany(mappedBy = "users",cascade = {CascadeType.MERGE})
    private List<Comentario> comments;

    public Usuario(Long id, @NotBlank String email, @NotBlank String pass, List<Comentario> comments) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.comments = comments;
    }
    public Usuario(){};


    public List<Comentario> getComments() {
        return comments;
    }

    public void setComments(List<Comentario> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
