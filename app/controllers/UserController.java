package controllers;

import appService.UserAppService;
import data.models.BaseModel;
import exceptions.AppException;
import exceptions.ObjectNotFoundException;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Result;

import java.io.IOException;

/**
 * Created by eric on 8/17/15.
 */
public class UserController extends BaseController {

    public static UserAppService appService = null;

    static {
        appService = (appService ==null) ? new UserAppService() : appService;
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result createOrUpdate() throws IOException {
        try {
            BaseModel entity = appService.createOrUpdate(request().body().asJson());
            return BaseController.returnOk(Json.toJson(entity));
        }
        catch(AppException e){
            return ok(renderError(e));
        }
    }

    public static Result deleteById(Long id){
        try{
            return BaseController.returnOk(Json.toJson(appService.deleteById(id)));
        } catch (ObjectNotFoundException e) {
            return ok(renderError(e));
        }
    }

    public static Result findAll(){
        try{
            return BaseController.returnOk(Json.toJson(appService.findAll()));
        } catch (ObjectNotFoundException e) {
            return ok(renderError(e));
        }
    }

    public static Result findById(Long id){
        try{
            return BaseController.returnOk(Json.toJson(appService.findById(id)));
        } catch (ObjectNotFoundException e) {
            return ok(renderError(e));
        }
    }
}
