package com.carlosaguilar.SpringRestPostgree.controller;

import com.carlosaguilar.SpringRestPostgree.exception.RecordNotFoundException;
import com.carlosaguilar.SpringRestPostgree.model.Lugar;
import com.carlosaguilar.SpringRestPostgree.model.Usuario;
import com.carlosaguilar.SpringRestPostgree.services.LugarService;
import com.carlosaguilar.SpringRestPostgree.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UsuarioServiceController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers() {
        List<Usuario> list = service.getAllUsers();

        return new ResponseEntity<List<Usuario>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Usuario entity = service.getUserById(id);

        return new ResponseEntity<Usuario>(entity, new HttpHeaders(), HttpStatus.OK);
    }

@GetMapping("/search/{email}")
    public ResponseEntity<List<Usuario>> getUsersByEmail(@PathVariable("email") String name) {
        List<Usuario> list = service.getUsersByEmail(name);

        return new ResponseEntity<List<Usuario>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Usuario> createUser(@Valid @RequestBody Usuario myUser){
        Usuario created = service.createUser(myUser);
        return new ResponseEntity<Usuario>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Usuario> UpdateUser(@Valid @RequestBody Usuario myUser)
            throws RecordNotFoundException {
        Usuario updated = service.createUser(myUser);
        return new ResponseEntity<Usuario>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUserById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteUserById(id);
        return HttpStatus.ACCEPTED;
    }

}


