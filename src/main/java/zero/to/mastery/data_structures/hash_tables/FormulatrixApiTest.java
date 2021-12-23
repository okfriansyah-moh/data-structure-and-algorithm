package zero.to.mastery.data_structures.hash_tables;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class FormulatrixApiTest {
    FormulatrixApi formulatrixApi = new FormulatrixApi();

    @Test
    public void testRegisterSaveSuccessJson() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        Assert.assertNotNull(formulatrixApi.dataSets);
        Assert.assertTrue(formulatrixApi.dataSets.containsKey("test1"));
    }

    @Test
    public void testRegisterSaveSuccessXml() {
        formulatrixApi.register("test2", formulatrixApi.getXmlData(), 2);
        Assert.assertNotNull(formulatrixApi.dataSets);
        Assert.assertTrue(formulatrixApi.dataSets.containsKey("test2"));
    }

    @Test
    public void testRegisterSaveFailedWrongFormat() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 2);
        Assert.assertEquals(new HashMap<>(), formulatrixApi.dataSets);
        Assert.assertFalse(formulatrixApi.dataSets.containsKey("test1"));
    }

    @Test
    public void testRegisterSaveDataDuplicate() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        Assert.assertNotNull(formulatrixApi.dataSets);
        Assert.assertTrue(formulatrixApi.dataSets.containsKey("test1"));
        Assert.assertEquals(1, formulatrixApi.dataSets.size());
    }

    @Test
    public void testRetrieve() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        Assert.assertEquals(formulatrixApi.retrieve("test1"), formulatrixApi.getJsonData());
    }

    @Test
    public void testRetrieveDataNotFound() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        Assert.assertEquals("",formulatrixApi.retrieve("test2"));
    }

    @Test
    public void testGetType() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        Assert.assertEquals(formulatrixApi.getType("test1"), 1);
    }

    @Test
    public void testGetTypeDataNotFound() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        Assert.assertEquals(formulatrixApi.getType("test2"), 0);
    }

    @Test
    public void testDeRegisterData() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        formulatrixApi.deRegister("test1");
        Assert.assertEquals(new HashMap<>(), formulatrixApi.dataSets);
        Assert.assertFalse(formulatrixApi.dataSets.containsKey("test1"));
    }

    @Test
    public void testDeRegisterDataNotFound() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        formulatrixApi.deRegister("test2");
        Assert.assertNotNull(formulatrixApi.dataSets);
        Assert.assertTrue(formulatrixApi.dataSets.containsKey("test1"));
    }

}
