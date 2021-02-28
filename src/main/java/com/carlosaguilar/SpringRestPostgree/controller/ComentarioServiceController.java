package com.carlosaguilar.SpringRestPostgree.controller;

import com.carlosaguilar.SpringRestPostgree.exception.RecordNotFoundException;
import com.carlosaguilar.SpringRestPostgree.model.Comentario;
import com.carlosaguilar.SpringRestPostgree.services.ComentarioService;
import com.carlosaguilar.SpringRestPostgree.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("/place/{id}/comentary")
//@RequestMapping("/comentary/{id}/user")
@RequestMapping("/comentary")
public class ComentarioServiceController {


    @Autowired
    ComentarioService service;
    @Autowired
    UsuarioService serviceUsuario;

    /**
     *
     * @param questionId
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Comentario>> getAllComments(@PathVariable Long questionId) {
        List<Comentario> list = service.getAllComments();

        return new ResponseEntity<List<Comentario>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> getComentaryById(@PathVariable Long questionId, @PathVariable("id") Long id)
            throws RecordNotFoundException {
        Comentario entity = service.getComentaryById(id);

        return new ResponseEntity<Comentario>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/place/{id}")
    public ResponseEntity<List<Comentario>> getAllCommentsByIdPlace(@PathVariable("id") Long id) {
        List<Comentario> list = service.getAllCommentsByIdPlace(id);
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("place/{place_id}/user/{user_id}")
    public ResponseEntity<Comentario> createComentary(@PathVariable("place_id") Long place_id,@PathVariable("user_id") Long user_id,@Valid @RequestBody Comentario myComentary) {
        Comentario entity = service.createComentary(myComentary,user_id,place_id);

        return new ResponseEntity<Comentario>(entity, new HttpHeaders(), HttpStatus.OK);
    }


}



/* @GetMapping("/search/{name}")
    public ResponseEntity<List<Lugar>> getPlacesByTitle(@PathVariable("name") String name) {
        List<Lugar> list = service.getPlacesName(name);

        return new ResponseEntity<List<Lugar>>(list, new HttpHeaders(), HttpStatus.OK);
    }*//*
 */
/*
 *//*

 */
/*




    @PostMapping
    public ResponseEntity<Comentario> createComentary(@PathVariable Long user_id,@Valid @RequestBody Comentario myComentary) {
        Comentario created = service.createComentary(myComentary,user_id);
        return new ResponseEntity<Comentario>(created, new HttpHeaders(), HttpStatus.OK);
    }

*//*
 */
/*

 *//*

 */
/*    @PutMapping
    public ResponseEntity<Comentario> UpdateComentary(@Valid @RequestBody Comentario myComentary)
            throws RecordNotFoundException {
        Comentario updated = service.createComentary(myComentary);
        return new ResponseEntity<Comentario>(updated, new HttpHeaders(), HttpStatus.OK);
    }*//*
 */
/*
 *//*

 */
/*


    @DeleteMapping("/{id}")
    public HttpStatus deleteComentaryById(@PathVariable Long questionId,@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteComentaryById(id);
        return HttpStatus.ACCEPTED;
    }

}

*//*
 */
/*

 */
