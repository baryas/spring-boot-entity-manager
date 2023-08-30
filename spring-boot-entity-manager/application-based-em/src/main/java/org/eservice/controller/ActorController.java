package org.eservice.controller;

import org.eservice.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ActorController {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;


   @GetMapping("/actor")
    public List<Actor> getAllTheActor(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        String jpql = "select a from Actor a";
        TypedQuery<Actor> query = entityManager.createQuery(jpql, Actor.class);

        return query.getResultList() ;

    }

    @PostMapping("/actor")
    public Actor saveActor(@RequestBody Actor actor){
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();

       entityManager.persist(actor);

       entityManager.getTransaction().commit();
       entityManager.close();

       return actor;

    }

    @GetMapping("/actor/{id}")
    public Actor getActorById(@PathVariable("id") Long id){
       EntityManager entityManager = entityManagerFactory.createEntityManager();

       entityManager.getTransaction().begin();

   Actor actorFound = entityManager.find(Actor.class,id);

       entityManager.getTransaction().commit();
       entityManager.close();

       return actorFound;

    }

    @PutMapping("/actor/{id}")
    public Actor updateActorById(@PathVariable("id") Long id, @RequestBody Actor actor){
     EntityManager entityManager = entityManagerFactory.createEntityManager();
     entityManager.getTransaction().begin();

     Actor actorFound = entityManager.find(Actor.class,id);

     actorFound.setName(actor.getName());
     actorFound.setYearBorn(actor.getYearBorn());

     entityManager.merge(actorFound);

     entityManager.getTransaction().commit();
     entityManager.close();

     return actorFound;

    }

    @DeleteMapping("/actor/{id}")
    public String deleteActorById(@PathVariable("id") Long id){
       EntityManager entityManager = entityManagerFactory.createEntityManager();

       entityManager.getTransaction().begin();
       Actor actorFound = entityManager.find(Actor.class, id);

       entityManager.remove(actorFound);

       entityManager.getTransaction().commit();
       entityManager.close();

       return "Actor is deleted from system " + actorFound;
    }

}
