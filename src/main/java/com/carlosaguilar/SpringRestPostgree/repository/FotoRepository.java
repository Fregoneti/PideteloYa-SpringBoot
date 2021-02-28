package com.carlosaguilar.SpringRestPostgree.repository;

import com.carlosaguilar.SpringRestPostgree.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {

    /**
     * Lista todas los fotos con una url parecida
     * @param url Url de la oto
     * @return Devuelve todas las fotos
     */
    @Query(
            value="SELECT * FROM photo AS ph WHERE ph.url LIKE %?1%",
            nativeQuery=true)
    public List<Foto> getPhotoByUrl(String url);
}
