package com.api.dao;

import com.api.model.Pelicula;

import java.util.List;

public interface PeliculaDAO {
        long save(Pelicula pelicula);
        Pelicula get(long id);
        List<Pelicula> list();
        void update (Pelicula pelicula);
        void delete(long id);

}
