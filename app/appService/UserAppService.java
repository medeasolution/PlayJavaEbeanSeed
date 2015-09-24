package appService;

import data.models.User;
import services.BaseCRUDService;
import services.UserService;

/**
 * Created by ecobos on 8/21/15.
 */
public class UserAppService extends BaseCRUDAppService {

    protected UserService service;
    public UserAppService(){
        this.service = new UserService();
    }

    public UserAppService(UserService service){
        this.service = service;
    }

    @Override
    BaseCRUDService getService() {
        return this.service;
    }

    @Override
    Class<?> getModelClass() {
        return User.class;
    }

}
