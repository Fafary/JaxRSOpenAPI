package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Professionnels extends User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    public Professionnels() {
    }

    public Professionnels(String name) {
        super(name);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}