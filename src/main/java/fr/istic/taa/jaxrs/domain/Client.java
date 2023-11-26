package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

// Client est une sous-classe de User, héritant de ses propriétés
@Entity
@DiscriminatorValue("client")
@XmlRootElement(name = "Client")
public class Client extends User implements Serializable {
    // Constructeur par défaut nécessaire pour JPA
    public Client() {}

    public Client(String name) {
        super(name);
    }

}
