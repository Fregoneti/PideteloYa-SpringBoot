package com.carlosaguilar.SpringRestPostgree.repository;

import com.carlosaguilar.SpringRestPostgree.model.Usuario;
import com.carlosaguilar.SpringRestPostgree.model.Lugar;
import com.carlosaguilar.SpringRestPostgree.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

    @Query(
            value="SELECT * FROM users AS u WHERE u.email LIKE %?1%",
            nativeQuery=true)
    public List<Usuario> getUserByEmail(String email);

}


