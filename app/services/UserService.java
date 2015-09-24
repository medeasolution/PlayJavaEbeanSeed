package services;

import data.dao.BaseDAO;
import data.dao.UserDAO;

/**
 * Created by eric on 9/23/15.
 */
public class UserService extends BaseCRUDService {

    public UserDAO dao;

    public UserService(){
        this.dao = new UserDAO();
    }

    public UserService(UserDAO userDao){
        this.dao = userDao;
    }

    @Override
    BaseDAO getDAO() {
        return this.dao;
    }
}
