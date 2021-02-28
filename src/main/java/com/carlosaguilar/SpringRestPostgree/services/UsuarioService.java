package com.carlosaguilar.SpringRestPostgree.services;

import com.carlosaguilar.SpringRestPostgree.exception.RecordNotFoundException;
import com.carlosaguilar.SpringRestPostgree.model.Usuario;
import com.carlosaguilar.SpringRestPostgree.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;


    /**
     * Sirve para recibir una lista de todos los usuarios (SIN FILTRO)
     * @return Arraylist si hay usuarios creados. Si no existe, devuelve un ArrayList vacio
     */
    public List<Usuario> getAllUsers() {
        List<Usuario> usersList = repository.findAll();

        if (usersList.size() > 0) {
            return usersList;
        } else {
            return new ArrayList<Usuario>();
        }
    }

    /**
     * Sirve para recibir un usuario con Id específicada
     * @param id Id del usuario
     * @return El lugar con dicha ID
     * @throws RecordNotFoundException
     */
    public Usuario getUserById(Long id) throws RecordNotFoundException {
        Optional<Usuario> user = repository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No user record exist for given id", id);
        }
    }

    /**
     * Crea un usuario nuevo
     * @param entity
     * @return Devuelve la entidad creada
     */
    public Usuario createUser(Usuario entity) {
        entity = repository.save(entity);
        return entity;
    }

    /**
     * Actualiza el usuario
     * @param entity
     * @return Devuelve el usuario
     * @throws RecordNotFoundException
     */
    public Usuario UpdateUser(Usuario entity) throws RecordNotFoundException {

        if (entity.getId() != null) {
            Optional<Usuario> user = repository.findById(entity.getId());

            if (user.isPresent()) {
                Usuario newEntity = user.get();
                //newEntity.setId(entity.getId());
                newEntity.setEmail(entity.getEmail());
                newEntity.setPass(entity.getPass());


                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException("User not found", entity.getId());
            }
        } else {
            throw new RecordNotFoundException("No id of user given", 0l);
        }
    }
    /**
     * Borra un usuario con una Id específica
     * @param id Id de un usuario
     * @throws RecordNotFoundException
     */
    public void deleteUserById(Long id) throws RecordNotFoundException {
        Optional<Usuario> user = repository.findById(id);

        if (user.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id", id);
        }
    }

    /**
     * Sirve para recibir una lista de todos los usuarios con un email parecido
     * @param email email del lugar
     * @return Arraylist si hay usuarios creados. Si no existe, devuelve un ArrayList vacio
     */
public List<Usuario> getUsersByEmail(String email) {
        List<Usuario> userList = repository.getUserByEmail(email);

        if (userList.size() > 0) {
            return userList;
        } else {
            return new ArrayList<Usuario>();
        }
    }

}

