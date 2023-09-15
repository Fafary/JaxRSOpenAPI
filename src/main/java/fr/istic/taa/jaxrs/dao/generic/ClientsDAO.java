package fr.istic.taa.jaxrs.dao.generic;

import doctolib.Clients;

public class ClientsDAO extends AbstractJpaDao<Long, Clients>{
    public ClientsDAO() {
        super(Clients.class);
    }
}
