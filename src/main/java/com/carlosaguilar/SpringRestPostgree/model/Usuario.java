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



    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    List<Comentario> comentarios;
    /**
     * Lista de comentarios de un usuario
     */

    public Usuario(Long id, @NotBlank String email, @NotBlank String pass, List<Comentario> comments) {
        this.id = id;
        this.email = email;
        this.pass = pass;

    }
    public Usuario(){};




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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
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
