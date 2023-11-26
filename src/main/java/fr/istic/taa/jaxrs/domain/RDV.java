package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.io.Serializable;

@Entity
@XmlRootElement(name = "RDV")
public class RDV implements Serializable {
    private Long id;
    private String date;
    @Column(name="Pro name")
    private Professionnel professionnel;
    private Client client;
    private String sujet;

    // Constructeur par défaut nécessaire pour JPA
    public RDV() {}

    public RDV(String date, Client client, Professionnel professionnel, String sujet) {
        this.date = date;
        this.client = client;
        this.professionnel = professionnel;
        this.sujet = sujet;
    }

    @Id
    @GeneratedValue
    @XmlElement(name = "id")
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    @XmlElement(name = "date")
    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    @XmlElement(name = "sujet")
    public String getSujet() { return sujet; }

    public void setSujet(String sujet) { this.sujet = sujet; }

    // Relation Many-to-One avec la classe Professionnel, annotée avec XML pour la sérialisation
    @ManyToOne
    @XmlElement(name = "professionnel")
    @XmlTransient
    public Professionnel getProfessionnel() { return professionnel; }

    public void setProfessionnel(Professionnel professionnel) { this.professionnel = professionnel; }

    // Relation Many-to-One avec la classe Client, annotée avec XML pour la sérialisation
    @ManyToOne
    @XmlElement(name = "client")
    @XmlTransient
    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }

}
