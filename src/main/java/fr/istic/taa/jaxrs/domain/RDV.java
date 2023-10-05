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
    private Professionnels professionnel;

    private Clients client;

    private String sujet;

    public RDV(String date, Clients client, Professionnels professionnel, String sujet) {
        this.date = date;
        this.client = client;
        this.professionnel = professionnel;
        this.sujet = sujet;
    }

    public RDV() {}

    @Id
    @GeneratedValue
    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "date")
    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    @XmlElement(name = "sujet")
    public String getSujet() { return sujet; }

    public void setSujet(String sujet) { this.sujet = sujet; }

    @ManyToOne
    @XmlElement(name = "professionnel")
    @XmlTransient
    public Professionnels getProfessionnel() {
        return professionnel;
    }

    public void setProfessionnel(Professionnels professionnel) {
        this.professionnel = professionnel;
    }

    @ManyToOne
    @XmlElement(name = "client")
    @XmlTransient
    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

}
