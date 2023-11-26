package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Client;
import fr.istic.taa.jaxrs.domain.RDV;

import java.util.List;

public class ClientDAO extends AbstractJpaDao<Long, Client>{
    // Constructeur par défaut de la classe ClientDAO
    public ClientDAO() {
        super();
        setClazz(Client.class);
    }

    // Méthode pour obtenir la liste des RDV d'un client spécifique
    public List<RDV> getRDVs(Client client) {
        String rdvs = "select r from RDV r where r.client = :client";

        return entityManager.createQuery(rdvs, RDV.class).setParameter("client", client).getResultList();
    }

}
