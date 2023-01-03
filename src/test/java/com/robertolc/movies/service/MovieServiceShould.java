package com.robertolc.movies.service;

import com.robertolc.movies.data.MovieRepository;
import com.robertolc.movies.model.Genre;
import com.robertolc.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {

                /*
        Al ser un MovieRepository una interface ya que para el ejemplo no realizamos
         la implementación de la clase vamos a mockear un objeto
         y asu vez también vamos a mockear sus metodos
         */
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        /*
        De igual manera como nuestra clase MovieRepository es una interface vamos a mockear su metodo
        findall para poder simular que devuelve una serie de peliculas
         */
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION, "Director1"),
                        new Movie(2, "Memento", 113, Genre.THRILLER, "Director2"),
                        new Movie(3, "There's Something About Marty", 119, Genre.COMEDY, "Director3"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER, "Director4"),
                        new Movie(5, "Scream", 111, Genre.HORROR,"Director5"),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY, "Director6"),
                        new Movie(7, "Matrix", 136, Genre.ACTION, "Director7")
                )
        );

        Mockito.when(movieRepository.findById(2)).thenReturn(
                new Movie(2, "Memento", 113, Genre.THRILLER, "Director2")
        );

        movieService = new MovieService(movieRepository);

    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie> movies = movieService.findMovieByGenre(Genre.COMEDY);

        assertThat(getMoviesIds(movies), CoreMatchers.is(Arrays.asList(3,6)));
    }

    @Test
    public void return_movies_by_length() {

        Collection<Movie> movies = movieService.findMovieByLenght(119);

        assertThat(getMoviesIds(movies), CoreMatchers.is(Arrays.asList(2,3,4,5,6)));

    }

    @Test
    public void find_movies_by_template() {

        Movie template = new Movie(2,null, 150, Genre.ACTION, null);

        Collection<Movie> movies = movieService.findMoviesByTemplate(template);

        assertEquals(Collections.singletonList(2), getMoviesIds(movies));
        //assertThat(getMoviesIds(movies), CoreMatchers.is(Arrays.asList(2)));
    }

    /**
     * Descripción: Método que recibe una lista de peliculas y regresa una lista con sus ids
     * @param movies
     * @return
     */
    private static List<Integer> getMoviesIds(Collection<Movie> movies) {
        List<Integer> movieIds = movies.stream().map(Movie::getId).collect(Collectors.toList());
        return movieIds;
    }
}