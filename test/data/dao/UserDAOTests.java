package data.dao;

import exceptions.ObjectNotFoundException;

/**
 * Created by eric on 9/23/15.
 */
public class UserDAOTests extends BaseDAOTest {

    public UserDAO sut;

    public UserDAOTests() throws ObjectNotFoundException {
        super(new UserDAO());
        this.sut = new UserDAO();
    }

    @Override
    BaseDAO getSut() {
        return this.sut;
    }

    public Long exerciseCreateEntity() throws ObjectNotFoundException {
        return this.createUser();
    }
}
