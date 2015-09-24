package service;

import data.dao.UserDAO;
import data.models.BaseModel;
import data.models.User;
import services.BaseCRUDService;
import services.UserService;

/**
 * Created by eric on 8/17/15.
 */
public class UserServiceTests extends BaseCRUDServiceTests {

    public UserService sut;

    public UserServiceTests(){
        super();
        UserDAO dao = (UserDAO) this.mockDAO;
        this.sut = new UserService(dao);
    }

    @Override
    Class<?> getDAOClass() {
        return UserDAO.class;
    }

    @Override
    BaseModel getEntity() {
        return new User();
    }

    @Override
    BaseCRUDService getSut() {
        return this.sut;
    }
}
