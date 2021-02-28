package com.carlosaguilar.SpringRestPostgree.repository;

import com.carlosaguilar.SpringRestPostgree.model.Lugar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




@Repository
public interface LugarRepository
        extends JpaRepository<Lugar, Long> {

    /**
     * Lista todas los lugares con un nombre parecida
     * @param name Name del lugar
     * @return Devuelve todas las lugares
     */
    @Query(
            value="SELECT * FROM Lugares AS p WHERE p.name LIKE %?1% order by p.name asc OFFSET 0 ROWS FETCH FIRST 10 ROW ONLY;",
            nativeQuery=true)
    public List<Lugar> getByName(String name);

    /**
     * Lista todas los lugares con una direccion parecida
     * @param adress adress del lugar
     * @return Devuelve todas las lugares
     */
    @Query(
            value="SELECT * FROM Lugares AS p WHERE p.adress LIKE %?1% order by p.adress asc;",
            nativeQuery=true)
    public List<Lugar> getByAdress(String adress);

    /**
     * Lista todas los lugares con un telefono parecida
     * @param phone phone del lugar
     * @return Devuelve todas las lugares
     */
    @Query(
            value="SELECT * FROM Lugares AS p WHERE p.phone LIKE %?1% order by p.phone desc ;",
            nativeQuery=true)
    public List<Lugar> getByPhone(String phone);

}