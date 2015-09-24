package appService;

import data.models.BaseModel;
import exceptions.ObjectNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import play.libs.Json;
import services.BaseCRUDService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

/**
 * Created by eric on 8/19/15.
 */
public abstract class BaseCRUDAppServiceTests {

    abstract Class<?> getServiceClass();
    abstract BaseModel getEntity();
    abstract BaseCRUDAppService getSut();
    protected BaseCRUDService mockService;

    public BaseCRUDAppServiceTests() throws ObjectNotFoundException {
        this.mockService = Mockito.mock((Class<BaseCRUDService>) this.getServiceClass());
        when(this.mockService.findAll()).thenReturn(new ArrayList<>());
        when(this.mockService.findById(anyLong())).thenReturn(getEntity());
        when(this.mockService.save(anyObject())).thenReturn(getEntity());
        try {
            when(this.mockService.deleteById(anyLong())).thenReturn((long)1);
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_findById() throws ObjectNotFoundException {
        BaseModel entity = this.getSut().findById((long)1);
        Assert.assertEquals(entity.getId(), getEntity().getId());
    }

    @Test
    public void test_findAll() throws ObjectNotFoundException {
        List<?> entitiesList = this.getSut().findAll();
        Assert.assertEquals(entitiesList.size(), 0);
    }

    @Test
    public void test_save() throws ObjectNotFoundException {
        BaseModel entity = this.getSut().createOrUpdate(Json.toJson(this.getEntity()));
        Assert.assertEquals(entity.getId(), this.getEntity().getId());
    }

    @Test
    public void test_deleteById() throws ObjectNotFoundException {
        Long id = this.getSut().deleteById((long)1);
        Long expected = 1L;
        Assert.assertEquals(id, expected);
    }
}
