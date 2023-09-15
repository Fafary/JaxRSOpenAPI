package fr.istic.taa.jaxrs.dao.generic;

import doctolib.User;

public class UserDAO extends AbstractJpaDao<Long, User>{
    public UserDAO() {
        super(User.class);
    }
}
