package com.robertolc.movies.data;

import com.robertolc.movies.model.Movie;

import java.util.Collection;

/**
 * MovieRepository es una interface ya que para el ejemplo no es necesario
 * implementarla y solo la vamos a mockear con mockito para hacer la simulacion
 * de sus metodos para buscar peliculas
 */
public interface MovieRepository {
    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}
