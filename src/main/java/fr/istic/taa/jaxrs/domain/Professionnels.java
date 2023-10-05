package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@XmlRootElement(name = "Professionnels")
public class Professionnels extends User implements Serializable {

    private Long id;

    public Professionnels() {}

    public Professionnels(String name) {
        super(name);
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }
}