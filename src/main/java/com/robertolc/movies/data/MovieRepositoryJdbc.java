package com.robertolc.movies.data;

import com.robertolc.movies.model.Genre;
import com.robertolc.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Se implementa la interfaz MovieRepository
 */
public class MovieRepositoryJdbc implements MovieRepository {

    //De la librería spring-jdbc
    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {

        //declaramos un array de objetos para los argumentos en este caso solo el id
        Object[] args = { id };

        //Utilizamos queryForObject para consultar 1 valor por medio de su id
        return jdbcTemplate.queryForObject("select * from movies where id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {

        //Consultamos las peliculas de la BD y los transformamos en objetos
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        //Usamos el metodo update para hacer actualizaciones en la BD en este caso un Insert
        jdbcTemplate.update("insert into movies (name, minutes, genre, director) values (?,?,?,?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString(), movie.getDirector());
    }

    public Collection<Movie> findByName(String name) {

        //Traemos todas las peliculas en una colección de objetos
        Collection<Movie> allMovies = jdbcTemplate.query("select * from movies", movieMapper);
        //Creamos un colector de objetos para guardar las peliculas de la busqueda por nombre
        Collection<Movie> moviesFound = new ArrayList<>();

        for (Movie movie : allMovies) {
            //buscamos el nombre de la pelicula usando tolowercase y contains
            if(movie.getName().toLowerCase().contains(name.toLowerCase())){
                moviesFound.add(movie);
            }
        }

        return moviesFound;
    }

    public Collection<Movie> findByDirector(String director) {
        //Traemos todas las peliculas en una colección de objetos
        Collection<Movie> allMovies = jdbcTemplate.query("select * from movies", movieMapper);
        //Creamos un colector de objetos para guardar las peliculas de la busqueda por nombre
        Collection<Movie> moviesFound = new ArrayList<>();

        for (Movie movie : allMovies) {
            //buscamos el director de la pelicula usando tolowercase y contains
            if(movie.getDirector().toLowerCase().contains(director.toLowerCase())){
                moviesFound.add(movie);
            }
        }
        return moviesFound;
    }

    //Transforma cada registro de pelicula de la base de datos en un objeto Movie
    private static RowMapper<Movie> movieMapper = (rs, rowNum) ->
            new Movie(
                rs.getInt("id"),
                rs.getString("name"),
                Integer.valueOf(rs.getInt("minutes")),
                Genre.valueOf(rs.getString("genre")),
                rs.getString("director")
    );
}
