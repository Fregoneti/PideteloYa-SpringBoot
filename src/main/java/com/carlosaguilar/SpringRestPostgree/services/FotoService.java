package com.carlosaguilar.SpringRestPostgree.services;

import com.carlosaguilar.SpringRestPostgree.exception.RecordNotFoundException;
//import com.carlosaguilar.SpringRestPostgree.model.Comentario;
import com.carlosaguilar.SpringRestPostgree.model.Foto;
import com.carlosaguilar.SpringRestPostgree.model.Lugar;
import com.carlosaguilar.SpringRestPostgree.repository.FotoRepository;
import com.carlosaguilar.SpringRestPostgree.repository.LugarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FotoService {

    @Autowired
    FotoRepository repositoryFoto;
    @Autowired
    LugarRepository repositoryLugar;


    /**
     * Sirve para recibir una lista de todos las fotos (SIN FILTRO)
     * @return Arraylist si hay fotos creados. Si no existe, devuelve un ArrayList vacio
     */
    public List<Foto> getAllPhoto() {
        List<Foto> photosList = repositoryFoto.findAll();

        if (photosList.size() > 0) {
            return photosList;
        } else {
            return new ArrayList<Foto>();
        }
    }
    /**
     * Sirve para recibir una foto con Id específicada
     * @param id Id del lugar
     * @return El lugar con dicha ID
     * @throws RecordNotFoundException
     */
    public Foto getPhotoById(Long id) throws RecordNotFoundException {
        Optional<Foto> photo = repositoryFoto.findById(id);

        if (photo.isPresent()) {
            return photo.get();
        } else {
            throw new RecordNotFoundException("No photo record exist for given id", id);
        }
    }

    /**
     * Crea una foto nuevo
     * @param entity
     * @return Devuelve la entidad creada
     */
    public Foto createPhoto(Foto entity, Long place_id) {
        System.out.println("Creando foto");
        repositoryLugar.findById(place_id).map(lugar -> {
            entity.setLugar(lugar);
            return repositoryFoto.save(entity);
        });
        return repositoryFoto.save(entity);
    }

    /**
     * Actualiza la foto
     * @param entity
     * @return Devuelve la foto
     * @throws RecordNotFoundException
     */
    public Foto UpdateFoto(Foto entity) throws RecordNotFoundException
    {

        if(entity.getId()!=null)
        {
            Optional<Foto> foto = repositoryFoto.findById(entity.getId());

            if(foto.isPresent())
            {
                Foto newEntity = foto.get();
                //newEntity.setId(entity.getId());
                newEntity.setUrl(entity.getUrl());
                newEntity = repositoryFoto.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException("Photo not found",entity.getId());
            }
        }else{
            throw new RecordNotFoundException("No id of photo given",0l);
        }
    }
    /**
     * Borra una foto con una Id específica
     * @param id Id de una foto
     * @throws RecordNotFoundException
     */
    public void deletePhotoById(Long id) throws RecordNotFoundException {
        Optional<Foto> photo = repositoryFoto.findById(id);

        if (photo.isPresent()) {
            repositoryFoto.deleteById(id);
        } else {
            throw new RecordNotFoundException("No photo record exist for given id", id);
        }
    }

    /**
     * Sirve para recibir una lista de todos las fotos con una url parecida
     * @param url Url del lugar
     * @return Arraylist si hay fotos creados. Si no existe, devuelve un ArrayList vacio
     */
    public List<Foto> getPhotoUrl(String url) {
        List<Foto> photoList = repositoryFoto.getPhotoByUrl(url);

        if (photoList.size() > 0) {
            return photoList;
        } else {
            return new ArrayList<Foto>();
        }
    }
}
