package fr.istic.taa.jaxrs.dao.generic;

import doctolib.Professionnels;

public class ProfessionnelsDAO extends AbstractJpaDao<Long, Professionnels>{
    public ProfessionnelsDAO() {
        super(Professionnels.class);
    }
}
