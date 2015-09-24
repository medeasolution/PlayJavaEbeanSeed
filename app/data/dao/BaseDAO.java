package data.dao;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.Model;
import data.models.BaseModel;
import exceptions.ObjectNotFoundException;
import exceptions.ReturnError;

import java.util.List;

/**
 * Created by eric on 9/23/15.
 */
abstract public class BaseDAO {

    protected Model.Finder find = null;
    abstract public Class<?> getEntityClass();

    public BaseDAO(){
        this.find = new Model.Finder<>(this.getEntityClass());
    }

    public BaseModel save(BaseModel entity) {
        if(entity.getId()!=null){
            entity.update();
        }else{
            entity.insert();
        }
        return entity;
    }

    public BaseModel findById(Long id) {
        return (BaseModel) this.find.byId(id);
    }

    public List<BaseModel> findAll(){
        List<BaseModel> list = this.find.all();
        return list;
    }

    public Long deleteById(Long id) throws ObjectNotFoundException {
        BaseModel entity = (BaseModel) this.find.byId(id);
        if(entity!=null){
            entity.delete();
            return id;
        }else{
            throw new ObjectNotFoundException(ReturnError.ENTITY_NOT_FOUND, "Entity");
        }
    }

}
