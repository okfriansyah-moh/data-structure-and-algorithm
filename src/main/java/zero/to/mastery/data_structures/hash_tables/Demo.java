package zero.to.mastery.data_structures.hash_tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Demonstrates demo concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class Demo {
    public HashMap<String, HashMap<String, String>> dataSet = new HashMap<>();
    public HashMap<String, List<String>> indexSet = new HashMap<>();

    /**
     * Executes main logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.registerData("jakarta", new HashMap<String, String>() {{
            put("longitude", "0.6");
            put("latitude", "106");
        }});

        demo.registerData("jakarta", new HashMap<String, String>() {{
            put("population_level", "high");
        }});

        System.out.println(demo.findByIndexAndValue("population_level", "high"));
        System.out.println(demo.findByIndexAndValue("longitude", "0.6"));
        System.out.println(demo.findByIndexAndValue("longitude", "1"));
        demo.deleteKey("jakarta");
        System.out.println(demo.findByIndexAndValue("longitude", "0.6"));
        System.out.println(demo.findByIndexAndValue("population_level", "high"));
    }

    /**
     * Executes register data logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param key input value used by the register data process
     * @param attributes input value used by the register data process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void registerData(String key, HashMap<String, String> attributes) {
        dataSet.put(key, attributes);
        Set<String> keys = attributes.keySet();
        for (String attribute : keys) {
            registerIndex(attribute + ":" + attributes.get(attribute), key);
        }
    }

    /**
     * Executes register index logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param attributeValue input value used by the register index process
     * @param key input value used by the register index process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void registerIndex(String attributeValue, String key) {
        List<String> listOfKeys = indexSet.getOrDefault(attributeValue, new ArrayList<>());
        listOfKeys.add(key);

        indexSet.put(attributeValue, listOfKeys);
    }

    /**
     * Executes find by index and value logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param index input value used by the find by index and value process
     * @param value input value used by the find by index and value process
     * @return computed int result produced by the find by index and value process
     */
    public int findByIndexAndValue(String index, String value) {
        return indexSet.getOrDefault(index + ":" + value, new ArrayList<>()).size();
    }

    /**
     * Executes delete key logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param key input value used by the delete key process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void deleteKey(String key) {
        dataSet.remove(key);
        Set<String> keys = indexSet.keySet();
        for (String attribute : keys) {
            indexSet.get(attribute).remove(key);
        }

        System.out.println("delete successfully");
    }


}
