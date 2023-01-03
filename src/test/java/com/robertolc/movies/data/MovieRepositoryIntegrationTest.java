package com.robertolc.movies.data;

import com.robertolc.movies.model.Genre;
import com.robertolc.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepositoryJdbc;
    private DriverManagerDataSource dataSource;

    @Before
    public void setUp() throws Exception {
        //Para crear bases de datos en memoria para pruebas utilizamos la libreria h2database
        //Usamos DriverManagerDataSource para crear una conexión a la base de datos en memoria para el test
        dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL","sa","sa");

        //Ejecutamos el script de sql para crear la BD e insertar 3 peliculas
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        //para crear un jdbcTemplate necesitamos mandar un dataSource con la conexion a la BD
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //Creamos un ojeto movieReposioryJdbc
        movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {

        //Recuperamos las peliculas de la base de datos
        Collection<Movie> movies = movieRepositoryJdbc.findAll();

        //Para poder comparar objetos tuvimos que crear los metodos equals y hashCode en Movie
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Director1"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "Director2"),
                new Movie(3, "Matrix", 136, Genre.ACTION, "Director3")
        )));
    }

    @Test
    public void load_movie_by_id() {

        Movie movie = movieRepositoryJdbc.findById(2);

        assertThat(movie, CoreMatchers.is(new Movie(2, "Memento", 113, Genre.THRILLER, "Director2")));
    }

    @Test
    public void find_by_name() {
        Collection<Movie> movies = movieRepositoryJdbc.findByName("meme");

        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(2, "Memento", 113, Genre.THRILLER, "Director2")
        )));
    }

    @Test
    public void find_by_director() {
        Collection<Movie> movies = movieRepositoryJdbc.findByDirector("Director3");

        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(3, "Matrix", 136, Genre.ACTION, "Director3")
        )));

    }

    @Test
    public void insert_a_movie() {

        //Creamos el objeto movie que vamos a insertar en la BD
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER, "Director4");
        //Insertamos la pelicula
        movieRepositoryJdbc.saveOrUpdate(movie);
        //Hacemos la busqueda de la pelicula que insertamos por el id
        //Asumimos que su id es 4 ya que solo teníamos 3 registros
        Movie movieFromDb = movieRepositoryJdbc.findById(4);

        assertThat(movieFromDb, CoreMatchers.is(new Movie(4,"Super 8", 112, Genre.THRILLER, "Director4")));
    }

    @After
    public void tearDown() throws Exception {
        //Remove H2 files
        //Para borrar los datos de la bd después de cada test para evitar que se dupliquen los datos
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files"); //"shutdown" is also enough for men db
    }
}