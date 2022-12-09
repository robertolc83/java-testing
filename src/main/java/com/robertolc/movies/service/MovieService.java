package com.robertolc.movies.service;

import com.robertolc.movies.data.MovieRepository;
import com.robertolc.movies.model.Genre;
import com.robertolc.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    //Necesitamos un repositorio que es donde tenemos guardadas las películas
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMovieByGenre(Genre genre) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByLenght(int length) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }
}
