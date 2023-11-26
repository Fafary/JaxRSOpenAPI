package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

// Utilisation de l'héritage avec une table unique
// Spécification de la colonne discriminante pour distinguer les sous-classes
// et une valeur discriminante pour cette classe spécifique
// Annotation indiquant que cette classe peut être utilisée comme racine d'un document XML
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "stakeholder")
@DiscriminatorValue("user")
@XmlRootElement(name = "User")
public class User implements Serializable {
    // Clé primaire générée automatiquement
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // Constructeur par défaut nécessaire pour JPA
    public User() {}

    public User(String name) {
        this.name = name;
    }

    @XmlElement(name = "id")
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    @XmlElement(name = "name")
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}
