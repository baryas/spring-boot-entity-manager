package org.eservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long yearBorn;

    public Actor(Long id, String name, Long yearBorn) {
        this.id = id;
        this.name = name;
        this.yearBorn = yearBorn;
    }

    public Actor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(Long yearBorn) {
        this.yearBorn = yearBorn;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearBorn=" + yearBorn +
                '}';
    }
}
