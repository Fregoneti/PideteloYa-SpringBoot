package com.carlosaguilar.SpringRestPostgree.controller;

import com.carlosaguilar.SpringRestPostgree.exception.RecordNotFoundException;
import com.carlosaguilar.SpringRestPostgree.model.Lugar;
import com.carlosaguilar.SpringRestPostgree.services.LugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/place")
public class LugarServiceController {

    @Autowired
    LugarService service;

    @GetMapping
    public ResponseEntity<List<Lugar>> getAllPlaces() {
        List<Lugar> list = service.getAllPlaces();

        return new ResponseEntity<List<Lugar>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lugar> getPlaceById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Lugar entity = service.getPlaceById(id);

        return new ResponseEntity<Lugar>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Lugar>> getPlacesByName(@PathVariable("name") String name) {
        List<Lugar> list = service.getPlacesName(name);

        return new ResponseEntity<List<Lugar>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/searchphone/{phone}")
    public ResponseEntity<List<Lugar>> getPlacesByPhone(@PathVariable("phone") String phone) {
        List<Lugar> list = service.getPlacesPhone(phone);

        return new ResponseEntity<List<Lugar>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/searchadress/{adress}")
    public ResponseEntity<List<Lugar>> getPlacesByAdress(@PathVariable("adress") String adress) {
        List<Lugar> list = service.getPlacesByAdress(adress);

        return new ResponseEntity<List<Lugar>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Lugar> createPlace(@Valid @RequestBody Lugar myPlace) {
        Lugar created = service.createPlace(myPlace);
        return new ResponseEntity<Lugar>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Lugar> Updateplace(@Valid @RequestBody Lugar myPlace)
            throws RecordNotFoundException {
        Lugar updated = service.createPlace(myPlace);
        return new ResponseEntity<Lugar>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePlaceById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deletePlaceById(id);
        return HttpStatus.ACCEPTED;
    }

}


