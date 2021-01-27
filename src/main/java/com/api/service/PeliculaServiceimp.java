package com.api.service;

import com.api.dao.PeliculaDAO;
import com.api.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class PeliculaServiceimp implements PeliculaService {

    @Autowired
    private PeliculaDAO peliculaDAO;

    @Override
    public long save(Pelicula pelicula) {
         return peliculaDAO.save(pelicula);

    }

    @Override
    @Transactional
    public Pelicula get(long id) {
        return peliculaDAO.get(id);
    }

    @Override
    @Transactional
    public List<Pelicula> list() {

        return peliculaDAO.list();
    }

    @Override
    @Transactional
    public void update (Pelicula pelicula) {
        peliculaDAO.update(pelicula);
    }

    @Override
    @Transactional
    public void delete(long id) {
        peliculaDAO.delete(id);
    }
}
