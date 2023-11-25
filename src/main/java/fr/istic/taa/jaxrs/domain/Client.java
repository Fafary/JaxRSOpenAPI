package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@DiscriminatorValue("client")
@XmlRootElement(name = "Client")
public class Client extends User implements Serializable {
    public Client() {}

    public Client(String name) {
        super(name);
    }

}
