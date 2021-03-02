package com.carlosaguilar.SpringRestPostgree.services;

import com.carlosaguilar.SpringRestPostgree.exception.RecordNotFoundException;
import com.carlosaguilar.SpringRestPostgree.model.Comentario;
import com.carlosaguilar.SpringRestPostgree.model.Foto;
import com.carlosaguilar.SpringRestPostgree.model.Lugar;
import com.carlosaguilar.SpringRestPostgree.model.Usuario;
import com.carlosaguilar.SpringRestPostgree.repository.ComentarioRepository;
import com.carlosaguilar.SpringRestPostgree.repository.LugarRepository;
import com.carlosaguilar.SpringRestPostgree.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ComentarioService {

    @Autowired
    ComentarioRepository repositoryComentario;
    @Autowired
    LugarRepository repositoryLugar;

    @Autowired
    UsuarioRepository repositoryUsuario;

    /**
     * Sirve para recibir una lista de todos los comentarios (SIN FILTRO)
     * @return Arraylist si hay comentarios creados. Si no existe, devuelve un ArrayList vacio
     */
    public List<Comentario> getAllComments() {
        List<Comentario> commentsList = repositoryComentario.findAll();

        if (commentsList.size() > 0) {
            return commentsList;
        } else {
            return new ArrayList<Comentario>();
        }
    }
    /**
     * Sirve para recibir un comentario con Id específicada
     * @param id Id del comentario
     * @return El comentario con dicha ID
     * @throws RecordNotFoundException
     */
    public Comentario getComentaryById(Long id) throws RecordNotFoundException {
        Optional<Comentario> comentary = repositoryComentario.findById(id);

        if (comentary.isPresent()) {
            return comentary.get();
        } else {
            throw new RecordNotFoundException("No comments record exist for given id", id);
        }
    }

    public List<Comentario> getAllCommentsByIdPlace(Long id){
        List<Comentario> order = repositoryComentario.getAllCommentsByIdPlace(id);

        if(order.size() > 0){
            return order;
        }else{
            return new ArrayList<>();
        }
    }

    /**
     * Crea un comentario nuevo
     * @param entity
     * @return Devuelve la entidad creada
     */
    public Comentario createComentary(Comentario entity, Long place_id, Long user_id) {
        System.out.println("Creando Comentario");
        Optional<Lugar> lugar;
        Optional<Usuario> usuario;
        lugar=repositoryLugar.findById(place_id);
        usuario=repositoryUsuario.findById(user_id);
        entity.setUsuario(usuario.get());
        entity.setLugar(lugar.get());

        return repositoryComentario.save(entity);
    }




    /**
     * Borra un comentario con una Id específica
     * @param id Id de un comentario
     * @throws RecordNotFoundException
     */
    public void deleteComentaryById(Long id) throws RecordNotFoundException {
        Optional<Comentario> comentary = repositoryComentario.findById(id);

        if (comentary.isPresent()) {
            repositoryComentario.deleteById(id);
        } else {
            throw new RecordNotFoundException("No comentary record exist for given id", id);
        }
    }

    /**
     * Sirve para recibir una lista de todos los comentarios con una descripcion parecido
     * @param id comentairo del lugar
     * @return Arraylist si hay usuarios creados. Si no existe, devuelve un ArrayList vacio
     */
    public List<Comentario> getComentaryName(Long id) {
        List<Comentario> comentaryList = repositoryComentario.getAllCommentsByIdPlace(id);

        if (comentaryList.size() > 0) {
            return comentaryList;
        } else {
            return new ArrayList<Comentario>();
        }
    }}

