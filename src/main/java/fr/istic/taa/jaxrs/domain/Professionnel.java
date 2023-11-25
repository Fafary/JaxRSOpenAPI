package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@DiscriminatorValue("professionnel")
@XmlRootElement(name = "Professionnel")
public class Professionnel extends User implements Serializable {
    public Professionnel() {}

    public Professionnel(String name) {
        super(name);
    }

}