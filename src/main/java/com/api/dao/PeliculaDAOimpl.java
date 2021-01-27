package com.api.dao;

import com.api.model.Pelicula;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PeliculaDAOimpl implements PeliculaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Pelicula pelicula)
    {
        sessionFactory.getCurrentSession().save(pelicula);
        return pelicula.getId();
    }

    @Override
    public Pelicula get(long id) {

        return sessionFactory.getCurrentSession().get(Pelicula.class,id);
    }

    @Override
    public List<Pelicula> list() {
        List<Pelicula> lista=sessionFactory.getCurrentSession().createQuery("from Pelicula").list();
        return lista;
    }

    @Override
    public void update(Pelicula pelicula) {
        Session session = sessionFactory.getCurrentSession();
        Pelicula oldpelicula = session.byId(Pelicula.class).load(pelicula.getId());
        oldpelicula.setTitulo(pelicula.getTitulo());
        oldpelicula.setGenero(pelicula.getGenero());
        oldpelicula.setSinopsis(pelicula.getSinopsis());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Pelicula pelicula = sessionFactory.getCurrentSession().byId(Pelicula.class).load(id);
        sessionFactory.getCurrentSession().delete(pelicula);
    }
}
