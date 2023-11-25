package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Client;
import fr.istic.taa.jaxrs.domain.RDV;

import java.util.List;

public class ClientDAO extends AbstractJpaDao<Long, Client>{
    public ClientDAO() {
        super();
        setClazz(Client.class);
    }

    public List<RDV> getRDVs(Client client) {
        String rdvs = "SELECT r FROM RDV r WHERE r.client = :client";

        return entityManager.createQuery(rdvs, RDV.class).setParameter("client", client).getResultList();
    }

}
