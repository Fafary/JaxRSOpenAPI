package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Professionnels;

public class ProfessionnelsDAO extends AbstractJpaDao<Long, Professionnels>{
    public ProfessionnelsDAO() {
        super();
        setClazz(Professionnels.class);
    }
}
