package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Professionnel;
import fr.istic.taa.jaxrs.domain.RDV;

import java.util.List;

public class ProfessionnelDAO extends AbstractJpaDao<Long, Professionnel>{
    // Constructeur par défaut de la classe ProfessionnelDAO
    public ProfessionnelDAO() {
        super();
        setClazz(Professionnel.class);
    }

    // Méthode pour obtenir la liste des RDV d'un client spécifique
    public List<RDV> getRDVs(Professionnel professionnel) {
        String rdvs = "select r from RDV r where r.professionnel = :professionnel";
        return entityManager.createQuery(rdvs, RDV.class).setParameter("professionnel", professionnel).getResultList();
    }

}
