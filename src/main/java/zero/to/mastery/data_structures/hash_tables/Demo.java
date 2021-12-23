package zero.to.mastery.data_structures.hash_tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Demo {
    public HashMap<String, HashMap<String, String>> dataSet = new HashMap<>();
    public HashMap<String, List<String>> indexSet = new HashMap<>();

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

    public void registerData(String key, HashMap<String, String> attributes) {
        dataSet.put(key, attributes);
        Set<String> keys = attributes.keySet();
        for (String attribute : keys) {
            registerIndex(attribute + ":" + attributes.get(attribute), key);
        }
    }

    public void registerIndex(String attributeValue, String key) {
        List<String> listOfKeys = indexSet.getOrDefault(attributeValue, new ArrayList<>());
        listOfKeys.add(key);

        indexSet.put(attributeValue, listOfKeys);
    }

    public int findByIndexAndValue(String index, String value) {
        return indexSet.getOrDefault(index + ":" + value, new ArrayList<>()).size();
    }

    public void deleteKey(String key) {
        dataSet.remove(key);
        Set<String> keys = indexSet.keySet();
        for (String attribute : keys) {
            indexSet.get(attribute).remove(key);
        }

        System.out.println("delete successfully");
    }


}
