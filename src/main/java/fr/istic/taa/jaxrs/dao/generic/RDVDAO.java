package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.RDV;

public class RDVDAO extends AbstractJpaDao<Long, RDV>{
    // Constructeur par défaut de la classe RDVDAO
    public RDVDAO() {
        super();
        setClazz(RDV.class);
    }

}
