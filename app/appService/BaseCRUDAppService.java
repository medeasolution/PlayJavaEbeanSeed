package appService;


import com.fasterxml.jackson.databind.JsonNode;
import data.models.BaseModel;
import exceptions.ObjectNotFoundException;
import play.libs.Json;
import services.BaseCRUDService;

import java.util.List;

/**
 * Created by eric on 8/17/15.
 */
public abstract class BaseCRUDAppService {

    abstract BaseCRUDService getService();

    abstract Class<?> getModelClass();

    public BaseModel createOrUpdate(JsonNode entity) throws ObjectNotFoundException {
        return this.getService().save(Json.fromJson(entity, (Class<BaseModel>) this.getModelClass()));
    }

    public List<?> findAll() throws ObjectNotFoundException {
        return this.getService().findAll();
    }

    public BaseModel findById(Long id) throws ObjectNotFoundException {
        return this.getService().findById(id);
    }

    public Long deleteById(Long id) throws ObjectNotFoundException {
        return this.getService().deleteById(id);
    }
}
