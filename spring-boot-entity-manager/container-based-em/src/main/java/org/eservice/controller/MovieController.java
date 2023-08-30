package org.eservice.controller;

import org.eservice.entity.Movie;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Transactional
public class MovieController {


    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping("/movie")
    public List<Movie> getAllMovie() {
        String jpql = "select m from Movie m";

        TypedQuery<Movie> query = entityManager.createQuery(jpql, Movie.class);

        return query.getResultList();

    }


    @PostMapping("/movie")
    public Movie saveMovie(@RequestBody Movie movie) {
        entityManager.persist(movie);
        return movie;
    }


    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable("id") Long id) {

        Movie movieFound = entityManager.find(Movie.class, id);
        return movieFound;
    }

    @PutMapping("/movie/{id}")
    public Movie updateMovieById(@PathVariable("id") Long id,@RequestBody Movie movie){
        Movie movieFound = entityManager.find(Movie.class, id);

        movieFound.setTitle(movie.getTitle());
        movieFound.setDescription(movie.getDescription());

        entityManager.merge(movieFound);

        return movieFound;
    }

    @DeleteMapping("/movie/{id}")
    public String deleteMovie(@PathVariable("id") Long id){

        Movie movieFound = entityManager.find(Movie.class, id);
         entityManager.remove(movieFound);

         return "Movie has been removed" + movieFound;
    }




}
