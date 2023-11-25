package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Professionnel;
import fr.istic.taa.jaxrs.domain.RDV;

import java.util.List;

public class ProfessionnelDAO extends AbstractJpaDao<Long, Professionnel>{
    public ProfessionnelDAO() {
        super();
        setClazz(Professionnel.class);
    }

    public List<RDV> getRDVs(Professionnel professionnel) {
        String rdvs = "SELECT r FROM RDV r WHERE r.professionnel = :professionnel";
        return entityManager.createQuery(rdvs, RDV.class).setParameter("professionnel", professionnel).getResultList();
    }

}
