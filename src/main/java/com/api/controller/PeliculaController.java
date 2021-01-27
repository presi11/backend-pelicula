package com.api.controller;

import com.api.service.PeliculaService;
import com.api.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})

public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/api/pelicula/all")
    public ResponseEntity<List<Pelicula>> getPeliculas(){

        List<Pelicula> list = peliculaService.list();
        return  ResponseEntity.ok().body(list);

    }

    //save pelicula
    @PostMapping("/api/pelicula")
    public String save(@RequestBody Pelicula pelicula){
        long id = peliculaService.save(pelicula);
        return "{\"success\":1}";
    }

    @GetMapping("/api/pelicula/{id}")
    public ResponseEntity<Pelicula> get(@PathVariable("id") int id){
        Pelicula pelicula = peliculaService.get(id);
        return ResponseEntity.ok().body(pelicula);
    }

    @PutMapping("/api/pelicula/{id}")
    public String update(@RequestBody Pelicula pelicula){
        peliculaService.update(pelicula);
        return "{\"success\":1}";

    }

    @DeleteMapping("/api/pelicula/{id}")
    public String delete(@PathVariable("id") long id){
        peliculaService.delete(id);
        return "{\"success\":1}";

    }

}
