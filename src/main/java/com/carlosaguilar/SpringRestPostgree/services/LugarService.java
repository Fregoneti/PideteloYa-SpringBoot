package com.carlosaguilar.SpringRestPostgree.services;


import com.carlosaguilar.SpringRestPostgree.exception.RecordNotFoundException;
import com.carlosaguilar.SpringRestPostgree.exception.RecordNotFoundException;
import com.carlosaguilar.SpringRestPostgree.model.Foto;
import com.carlosaguilar.SpringRestPostgree.model.Lugar;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.carlosaguilar.SpringRestPostgree.repository.FotoRepository;
import com.carlosaguilar.SpringRestPostgree.repository.LugarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LugarService {

    @Autowired
    LugarRepository repository;

    @Autowired
    FotoRepository repositoryphoto;

    /**
     * Sirve para recibir una lista de todos los lugares (SIN FILTRO)
     * @return Arraylist si hay lugares creados. Si no existe, devuelve un ArrayList vacio
     */
    public List<Lugar> getAllPlaces()
    {
        List<Lugar> placesList = repository.findAll();

        if(placesList.size() > 0) {
            return placesList;
        } else {
            return new ArrayList<Lugar>();
        }
    }

    /**
     * Sirve para recibir un lugar con Id específicada
     * @param id Id del lugar
     * @return El lugar con dicha ID
     * @throws RecordNotFoundException
     */
    public Lugar getPlaceById(Long id) throws RecordNotFoundException
    {
        Optional<Lugar> place = repository.findById(id);

        if(place.isPresent()) {
            return place.get();
        } else {
            throw new RecordNotFoundException("No places record exist for given id",id);
        }
    }

    /**
     * Crea un lugar nuevo
     * @param entity
     * @return Devuelve la entidad creada
     */
    public Lugar createPlace(Lugar entity){
        System.out.println("Creando lugar");
        entity = repository.save(entity);
               return entity;
    }

    /**
     * Actualiza el lugar
     * @param entity
     * @return Devuelve el lugar
     * @throws RecordNotFoundException
     */
    public Lugar UpdatePlace(Lugar entity) throws RecordNotFoundException
    {

        if(entity.getId()!=null)
        {
            Optional<Lugar> place = repository.findById(entity.getId());

            if(place.isPresent())
            {
                Lugar newEntity = place.get();
                //newEntity.setId(entity.getId());
                newEntity.setName(entity.getName());
                newEntity.setPhone(entity.getPhone());
                newEntity.setAdress(entity.getAdress());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException("Place not found",entity.getId());
            }
        }else{
            throw new RecordNotFoundException("No id of place given",0l);
        }
    }

    /**
     * Borra un lugar con una Id específica
     * @param id Id de un lugar
     * @throws RecordNotFoundException
     */
    public void deletePlaceById(Long id) throws RecordNotFoundException
    {
        Optional<Lugar> place = repository.findById(id);

        if(place.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No place record exist for given id",id);
        }
    }


    /**
     * Sirve para recibir una lista de todos los lugares con un nombre parecido
     * @param name Nombre del lugar
     * @return Arraylist si hay lugares creados. Si no existe, devuelve un ArrayList vacio
     */
    public List<Lugar> getPlacesName(String name) {
        List<Lugar> placeList = repository.getByName(name);

        if(placeList.size() > 0) {
            return placeList;
        } else {
            return new ArrayList<Lugar>();
        }
    }

    /**
     * Sirve para recibir una lista de todos los lugares con un telefono parecido
     * @param phone Telefono del lugar
     * @return Arraylist si hay lugares creados con dicho telefono  Si no existe, devuelve un ArrayList vacio
     */
    public List<Lugar> getPlacesPhone(String phone) {
        List<Lugar> placeList = repository.getByPhone(phone);

        if(placeList.size() > 0) {
            return placeList;
        } else {
            return new ArrayList<Lugar>();
        }
    }

    /**
     * Sirve para recibir una lista de todos los lugares con un email parecido
     * @param email Email del lugar
     * @return Arraylist si hay lugares creados con dicho email  Si no existe, devuelve un ArrayList vacio
     */
    public List<Lugar> getPlacesByAdress(String adress) {
        List<Lugar> placeList = repository.getByAdress(adress);

        if(placeList.size() > 0) {
            return placeList;
        } else {
            return new ArrayList<Lugar>();
        }
    }



}
