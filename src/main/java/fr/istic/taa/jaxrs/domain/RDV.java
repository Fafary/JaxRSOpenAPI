package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getSujet() { return sujet; }

    public void setSujet(String sujet) { this.sujet = sujet; }

    @ManyToOne
    public Professionnels getProfessionnel() {
        return professionnel;
    }

    public void setProfessionnel(Professionnels professionnel) {
        this.professionnel = professionnel;
    }

    @ManyToOne
    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

}
