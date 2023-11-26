package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.User;

public class UserDAO extends AbstractJpaDao<Long, User>{
    // Constructeur par défaut de la classe UserDAO
    public UserDAO() {
        super();
        setClazz(User.class);
    }

}
