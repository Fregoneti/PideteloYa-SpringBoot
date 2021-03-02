package com.carlosaguilar.SpringRestPostgree.controller;


import com.carlosaguilar.SpringRestPostgree.exception.RecordNotFoundException;
//import com.carlosaguilar.SpringRestPostgree.model.Comentario;
import com.carlosaguilar.SpringRestPostgree.model.Foto;
import com.carlosaguilar.SpringRestPostgree.model.Lugar;
import com.carlosaguilar.SpringRestPostgree.services.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/photo")
public class FotoServiceController {


    @Autowired
    FotoService service;


     @GetMapping("/place/{place_id}")
    public ResponseEntity<Foto> getPhotoById(@PathVariable Long place_id,@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Foto entity = service.getPhotoById(id);

        return new ResponseEntity<Foto>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/place/{lugar_id}")
    public ResponseEntity<Foto> createPhoto(@PathVariable("lugar_id") Long lugar_id, @RequestBody Foto myPhoto) {
        System.out.println("Creando foto");
        Foto created = service.createPhoto(myPhoto,lugar_id);
        return new ResponseEntity<Foto>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteComentaryById(@PathVariable Long questionId,@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deletePhotoById(id);
        return HttpStatus.ACCEPTED;
    }

    @GetMapping("/search/{url}")
    public ResponseEntity<List<Foto>> getFotoUrl(@PathVariable("url") String url) {
        List<Foto> list = service.getPhotoUrl(url);

        return new ResponseEntity<List<Foto>>(list, new HttpHeaders(), HttpStatus.OK);
    }



   @PutMapping
    public ResponseEntity<Foto> UpdateComentary(@Valid @RequestBody Foto myPhoto)
            throws RecordNotFoundException {
        Foto updated = service.UpdateFoto(myPhoto);
        return new ResponseEntity<Foto>(updated, new HttpHeaders(), HttpStatus.OK);
    }

}


