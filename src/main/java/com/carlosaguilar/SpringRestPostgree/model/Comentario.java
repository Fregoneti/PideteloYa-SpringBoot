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
    /**
     * Un set de usuario que ha comentado
     */
    @JsonIgnoreProperties(value = {"comments"}, allowSetters = true)
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "user_comentary", joinColumns = @JoinColumn(name = "comentary_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Usuario> users;

    /**
     * Un set del lugar comentado
     */
    @JsonIgnoreProperties(value = {"comments"}, allowSetters = true)
    @JoinTable(name = "placesComments", joinColumns = @JoinColumn(name = "comentary_id"), inverseJoinColumns = @JoinColumn(name = "place_id"))
    @ManyToMany(cascade = {CascadeType.MERGE})
    private Set<Lugar> placesComments;


    public Comentario() {
    }

    public Comentario(Long id, String description, Set<Usuario> users, Set<Lugar> placesComments) {
        this.id = id;
        this.description = description;
        this.users = users;
        this.placesComments = placesComments;
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

    public Set<Usuario> getUsers() {
        return users;
    }

    public void setUsers(Set<Usuario> users) {
        this.users = users;

    }

    public Set<Lugar> getPlacesComments() {
        return placesComments;
    }

    public void setPlacesComments(Set<Lugar> placesComments) {
        this.placesComments = placesComments;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", users=" + users +
                ", placesComments=" + placesComments +
                '}';
    }
}
