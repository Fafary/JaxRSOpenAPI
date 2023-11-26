package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

// Professionnel est une sous-classe de User, héritant de ses propriétés
@Entity
@DiscriminatorValue("professionnel")
@XmlRootElement(name = "Professionnel")
public class Professionnel extends User implements Serializable {
    // Constructeur par défaut nécessaire pour JPA
    public Professionnel() {}

    public Professionnel(String name) {
        super(name);
    }

}