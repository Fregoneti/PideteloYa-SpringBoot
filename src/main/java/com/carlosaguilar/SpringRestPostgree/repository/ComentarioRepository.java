package com.carlosaguilar.SpringRestPostgree.repository;

import com.carlosaguilar.SpringRestPostgree.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>  {



   /* @Query(value="SELECT p.* FROM pedido AS p INNER JOIN usuario_pedido AS up ON up.id_pedido=p.id WHERE up.id_usuario=?1", nativeQuery=true)
    public List<Order> getOrderByUserId(Long id);

    @Query(value="SELECT SUM(c.precio) FROM pedido AS p INNER JOIN pedido_comida AS pc ON pc.id_pedido=p.id INNER JOIN comida AS c ON pc.id_comida=c.id WHERE p.id=?1", nativeQuery=true)
    public double getAllPriceForOrder(Long id);*/

    /**
     * Lista todos los comentarios de un lugar con una id especifica
     * @param id Id del lugar
     * @return Devuelve todos los comentarios de un lugar con una id especifica
     */
    @Query(value="SELECT c.* FROM commentary AS c INNER JOIN place_comentary AS pc ON pc.comentary_id=c.id INNER JOIN place AS p ON pc.place_id=p.id WHERE c.id=?1", nativeQuery=true)
    public List<Comentario>  getAllCommentsByIdPlace(Long id);
}




