package service;

import data.dao.BaseDAO;
import data.models.BaseModel;
import exceptions.ObjectNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import services.BaseCRUDService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

/**
 * Created by eric on 7/21/15.
 */
public abstract class BaseCRUDServiceTests {

    abstract Class<?> getDAOClass();
    abstract BaseModel getEntity();
    abstract BaseCRUDService getSut();
    protected BaseDAO mockDAO;

    public BaseCRUDServiceTests(){
        this.mockDAO = Mockito.mock((Class<BaseDAO>) this.getDAOClass());
        when(this.mockDAO.findAll()).thenReturn(this.generateEntitiesList());
        when(this.mockDAO.findById(anyLong())).thenReturn(getEntity());
        when(this.mockDAO.save(anyObject())).thenReturn(getEntity());
        try {
            when(this.mockDAO.deleteById(anyLong())).thenReturn((long) 1);
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected List<BaseModel> generateEntitiesList(){
        List<BaseModel> entitiesList = new ArrayList<>();
        entitiesList.add(this.getEntity());
        return entitiesList;
    }

    @Test
    public void test_findById() throws ObjectNotFoundException {
        BaseModel entity = this.getSut().findById((long) 1);
        Assert.assertEquals(entity.getId(), getEntity().getId());
    }

    @Test
    public void test_findAll() throws ObjectNotFoundException {
        List<?> entitiesList = this.getSut().findAll();
        Assert.assertEquals(entitiesList.size(), 1);
    }

    @Test
    public void test_save() throws ObjectNotFoundException {
        BaseModel entity = this.getSut().save(this.getEntity());
        Assert.assertEquals(entity.getId(), this.getEntity().getId());
    }

    @Test
    public void test_deleteById() throws ObjectNotFoundException {
        Long id = this.getSut().deleteById((long) 1);
        Long expected = 1L;
        Assert.assertEquals(id, expected);
    }
}
