package appService;

import data.models.BaseModel;
import data.models.User;
import exceptions.ObjectNotFoundException;
import services.UserService;

/**
 * Created by eric on 8/19/15.
 */
public class UserAppServiceTests extends BaseCRUDAppServiceTests {

    public UserAppService sut;

    public UserAppServiceTests() throws ObjectNotFoundException {
        super();
        UserService service = (UserService) this.mockService;
        this.sut = new UserAppService(service);
    }

    @Override
    Class<?> getServiceClass() {
        return UserService.class;
    }

    @Override
    BaseModel getEntity() {
        return new User();
    }

    @Override
    BaseCRUDAppService getSut() {
        return this.sut;
    }
}