package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
