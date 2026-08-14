package zero.to.mastery.data_structures.hash_tables;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Demonstrates formulatrix api test concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class FormulatrixApiTest {
    FormulatrixApi formulatrixApi = new FormulatrixApi();

    @Test
    /**
     * Executes test register save success json logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void testRegisterSaveSuccessJson() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        Assert.assertNotNull(formulatrixApi.dataSets);
        Assert.assertTrue(formulatrixApi.dataSets.containsKey("test1"));
    }

    @Test
    /**
     * Executes test register save success xml logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void testRegisterSaveSuccessXml() {
        formulatrixApi.register("test2", formulatrixApi.getXmlData(), 2);
        Assert.assertNotNull(formulatrixApi.dataSets);
        Assert.assertTrue(formulatrixApi.dataSets.containsKey("test2"));
    }

    @Test
    /**
     * Executes test register save failed wrong format logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void testRegisterSaveFailedWrongFormat() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 2);
        Assert.assertEquals(new HashMap<>(), formulatrixApi.dataSets);
        Assert.assertFalse(formulatrixApi.dataSets.containsKey("test1"));
    }

    @Test
    /**
     * Executes test register save data duplicate logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void testRegisterSaveDataDuplicate() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        Assert.assertNotNull(formulatrixApi.dataSets);
        Assert.assertTrue(formulatrixApi.dataSets.containsKey("test1"));
        Assert.assertEquals(1, formulatrixApi.dataSets.size());
    }

    @Test
    /**
     * Executes test retrieve logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void testRetrieve() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        Assert.assertEquals(formulatrixApi.retrieve("test1"), formulatrixApi.getJsonData());
    }

    @Test
    /**
     * Executes test retrieve data not found logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void testRetrieveDataNotFound() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        Assert.assertEquals("",formulatrixApi.retrieve("test2"));
    }

    @Test
    /**
     * Executes test get type logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void testGetType() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        Assert.assertEquals(formulatrixApi.getType("test1"), 1);
    }

    @Test
    /**
     * Executes test get type data not found logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void testGetTypeDataNotFound() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        Assert.assertEquals(formulatrixApi.getType("test2"), 0);
    }

    @Test
    /**
     * Executes test de register data logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void testDeRegisterData() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        formulatrixApi.deRegister("test1");
        Assert.assertEquals(new HashMap<>(), formulatrixApi.dataSets);
        Assert.assertFalse(formulatrixApi.dataSets.containsKey("test1"));
    }

    @Test
    /**
     * Executes test de register data not found logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void testDeRegisterDataNotFound() {
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        formulatrixApi.deRegister("test2");
        Assert.assertNotNull(formulatrixApi.dataSets);
        Assert.assertTrue(formulatrixApi.dataSets.containsKey("test1"));
    }

}
