package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@XmlRootElement(name = "Clients")
public class Clients extends User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Clients() {
    }

    public Clients(String name) {
        super(name);
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

}
