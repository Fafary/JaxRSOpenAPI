package fr.istic.taa.jaxrs.dao.generic;

import doctolib.RDV;

public class RDVDAO extends AbstractJpaDao<Long, RDV>{
    public RDVDAO() {
        super(RDV.class);
    }
}
