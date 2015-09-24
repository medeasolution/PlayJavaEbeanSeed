package data.dao;

import data.models.BaseModel;
import exceptions.ObjectNotFoundException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import play.test.FakeApplication;
import play.test.Helpers;
import java.util.List;

/**
 * Created by eric on 7/14/15.
 */
public abstract class BaseDAOTest extends TestExercises {

    abstract BaseDAO getSut();

    public abstract Long exerciseCreateEntity() throws ObjectNotFoundException;

    public String getModelType(){
        return "TABLE";
    }

    public BaseDAOTest(BaseDAO sut){

    }
    public static FakeApplication app;

    @BeforeClass
    public static void startApp() {
        app = Helpers.fakeApplication(Helpers.inMemoryDatabase());
        Helpers.start(app);
    }

    @AfterClass
    public static void stopApp() {
        Helpers.stop(app);
    }


    @Test
    public void test_save_EntityId() throws ObjectNotFoundException {
        if (this.getModelType().equals("TABLE")){
            Assert.assertNotNull(this.exerciseCreateEntity());
        }else{
            Assert.assertTrue(true);
        }
    }

    @Test
    public void test_findById_Entity() throws ClassNotFoundException, NoSuchMethodException, ObjectNotFoundException {
        if (this.getModelType().equals("TABLE")){
            Long id = this.exerciseCreateEntity();
            BaseModel entity = this.getSut().findById(id);
            Assert.assertEquals(entity.getId(), id);
        }else{
            Assert.assertTrue(true);
        }
    }

    @Test
    public void test_findAll_EntitiesList() throws ObjectNotFoundException {
        this.exerciseCreateEntity();
        List<?> entities = this.getSut().findAll();
        Assert.assertTrue(entities.size() > 0);
    }

    @Test
    public void test_deleteById_Id() throws ObjectNotFoundException {
        if (this.getModelType().equals("TABLE")) {
            Long id = this.exerciseCreateEntity();
            Long deletedId = this.getSut().deleteById(id);
            Assert.assertEquals(id, deletedId);
            BaseModel entity = this.getSut().findById(id);
            Assert.assertEquals(entity, null);
        }else{
            Assert.assertTrue(true);
        }
    }

}
