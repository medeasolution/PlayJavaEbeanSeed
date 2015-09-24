package data.dao;

import data.models.User;

/**
 * Created by eric on 9/23/15.
 */
public class UserDAO extends BaseDAO{
    @Override
    public Class<?> getEntityClass() {
        return User.class;
    }
}
