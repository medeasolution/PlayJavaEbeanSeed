package data.dao;

import data.models.User;
import exceptions.InvalidRequiredParameter;
import exceptions.MissingRequiredFile;
import exceptions.ObjectNotFoundException;

import java.util.Date;

/**
 * Created by eric on 7/15/15.
 */
public abstract class TestExercises {

    public Long createUser(String username) throws ObjectNotFoundException {
        UserDAO dao = new UserDAO();
        User user = new User();
        dao.save(user);
        return user.getId();
    }

    public Long createUser() throws ObjectNotFoundException {
        return this.createUser("testUsername");
    }
}
