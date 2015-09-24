package services;

import data.dao.BaseDAO;
import data.models.BaseModel;
import exceptions.ObjectNotFoundException;

import java.util.List;

/**
 * Created by eric on 7/21/15.
 */
public abstract class BaseCRUDService {

    abstract BaseDAO getDAO();

    public List<?> findAll() throws ObjectNotFoundException {
        return this.getDAO().findAll();
    }

    public BaseModel findById(Long id) throws ObjectNotFoundException {
        return this.getDAO().findById(id);
    }

    public BaseModel save(BaseModel entity) throws ObjectNotFoundException {
        return this.getDAO().save(entity);
    }

    public Long deleteById(Long id) throws ObjectNotFoundException {
        return this.getDAO().deleteById(id);
    }
}
