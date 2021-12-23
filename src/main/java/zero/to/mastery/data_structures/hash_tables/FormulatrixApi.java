package zero.to.mastery.data_structures.hash_tables;

import java.util.HashMap;

/**
 *
 * A Formulatrix repository manager is a library that can be used to store and retrieve JSON string or XML string. A unique string is used to indicate the item being stored.
 * QUESTION:
 * • Implement a Formulatrix repository manager with the following specifications: ◦ The following public API must be implemented. Please notice the signatures.
 * ▪ // Store an item to the repository.
 * // Parameter itemType is used to differentiate JSON or XML.
 * // 1 = itemContent is a JSON string.
 * // 2 = itemContent is an XML string.
 * void Register( string itemName, string itemContent, int itemType )
 * ▪ // Retrieve an item from the repository. string Retrieve( string itemName )
 * ▪ // Retrieve the type of the item (JSON or XML). int GetType( string itemName )
 * ▪ // Remove an item from the repository. void Deregister( string itemName )
 * ▪ // Initialize the repository for use, if needed.
 * // You could leave it empty if you have your own way to make the repository ready for use // (e.g. using the constructor).
 * void Initialize()
 * ◦ In Register, a validation must be performed against the itemContent based on the given itemType. You must include the validation process in your code, but you do not have to implement the logic itself.
 * ◦ A registered item should be protected from an overwrite.
 * ◦ If you use Initialize, it must be used just once after the repository instance is created.
 * • Write a document that explains the test scenarios that could be used to verify the above public API of this class. Or, alternatively, write the unit tests.
 */

public class FormulatrixApi {
    public HashMap<String, HashMap<String, Integer>> dataSets = new HashMap<>();

    public String getJsonData() {
        return "{\n" +
                "    \"glossary\": {\n" +
                "        \"title\": \"example glossary\",\n" +
                "\t\t\"GlossDiv\": {\n" +
                "            \"title\": \"S\",\n" +
                "\t\t\t\"GlossList\": {\n" +
                "                \"GlossEntry\": {\n" +
                "                    \"ID\": \"SGML\",\n" +
                "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
                "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
                "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
                "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
                "\t\t\t\t\t\"GlossDef\": {\n" +
                "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
                "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
                "                    },\n" +
                "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }

    public String getXmlData() {
        return "<breakfast_menu>\n" +
                "<food>\n" +
                "<name>Belgian Waffles</name>\n" +
                "<price>$5.95</price>\n" +
                "<description>Two of our famous Belgian Waffles with plenty of real maple syrup</description>\n" +
                "<calories>650</calories>\n" +
                "</food>\n" +
                "<food>\n" +
                "<name>Strawberry Belgian Waffles</name>\n" +
                "<price>$7.95</price>\n" +
                "<description>Light Belgian waffles covered with strawberries and whipped cream</description>\n" +
                "<calories>900</calories>\n" +
                "</food>\n" +
                "<food>\n" +
                "<name>Berry-Berry Belgian Waffles</name>\n" +
                "<price>$8.95</price>\n" +
                "<description>Light Belgian waffles covered with an assortment of fresh berries and whipped cream</description>\n" +
                "<calories>900</calories>\n" +
                "</food>\n" +
                "<food>\n" +
                "<name>French Toast</name>\n" +
                "<price>$4.50</price>\n" +
                "<description>Thick slices made from our homemade sourdough bread</description>\n" +
                "<calories>600</calories>\n" +
                "</food>\n" +
                "<food>\n" +
                "<name>Homestyle Breakfast</name>\n" +
                "<price>$6.95</price>\n" +
                "<description>Two eggs, bacon or sausage, toast, and our ever-popular hash browns</description>\n" +
                "<calories>950</calories>\n" +
                "</food>\n" +
                "</breakfast_menu>";
    }

    public static void main(String[] args) {
        FormulatrixApi formulatrixApi = new FormulatrixApi();
        System.out.println("=================================FORMULATRIX TEST==================================");
        System.out.println("=================================SAVE DATA WITH JSON FORMAT==================================");
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        System.out.println("=================================TEST CASE 1 SAVE DATA WITH SAME ITEM NAME==================================");
        formulatrixApi.register("test1", formulatrixApi.getJsonData(), 1);
        System.out.println("=================================TEST CASE 2 SAVE DATA WITH WRONG FORMAT==================================");
        formulatrixApi.register("test2", formulatrixApi.getXmlData(), 1);
        System.out.println("=================================SAVE DATA WITH XML FORMAT==================================");
        formulatrixApi.register("test2", formulatrixApi.getXmlData(), 2);
        System.out.println("=================================RETRIEVE DATA FOR TEST 1==================================");
        System.out.println(formulatrixApi.retrieve("test1"));
        System.out.println("=================================GET TYPE DATA FOR TEST 1==================================");
        System.out.println(formulatrixApi.getType("test1"));
        System.out.println("=================================RETRIEVE DATA FOR TEST 2==================================");
        System.out.println(formulatrixApi.retrieve("test2"));
        System.out.println("=================================GET TYPE DATA FOR TEST 2==================================");
        System.out.println(formulatrixApi.getType("test2"));
        System.out.println("=================================DEREGISTER TEST 1==================================");
        formulatrixApi.deRegister("test1");
        System.out.println("=================================PRINT CURRENT DATASETS==================================");
        System.out.println("Current DataSets = " + formulatrixApi.dataSets);
    }

    /**
        This method is used to store an item to the data structure.
        Parameter itemType is used to differentiate JSON or XML.
        1 = itemContent is a JSON string.
        2 = itemContent is an XML string.
        @param itemName
        @param itemContent
        @param itemType
     */
    public void register(String itemName, String itemContent, int itemType) {
        if (validateItemType(itemContent, itemType) && checkDataIsPresent(itemName)) {
            HashMap<String,Integer> itemData = new HashMap<>();
            itemData.put(itemContent,itemType);
            saveData(itemName, itemData);
        } else {
            System.out.println("Data do not pass the Validation, " +
                    "So The data for " + itemName + " cannot be saved");
        }
    }

    /**
        This method is used to validate itemContent based on itemType
        @param itemContent
        @param itemType
     */
    private boolean validateItemType(String itemContent, int itemType) {
        if ((itemType == 1 && itemContent.startsWith("{"))
                || (itemType == 2 && itemContent.startsWith("<"))) {
            return true;
        }
        return false;
    }

    /**
        This method is used to check whether the data is present or not.
        To avoid from overwriting
        @param itemName
     */
    private boolean checkDataIsPresent(String itemName) {
        boolean isPresent = dataSets.containsKey(itemName);
        System.out.println("Check Data is present by item Name " + itemName
                + " = " + isPresent);
        return !isPresent;
    }

    private void saveData(String key, HashMap<String, Integer> value) {
        dataSets.put(key,value);
        System.out.println("Data successfully saved for " + key);
    }

    /**
        Retrieve an item from the repository.
        @param itemName
     */
    public String retrieve(String itemName) {
        String result = "";
        if (!checkDataIsPresent(itemName)) {
            HashMap dataInHash = dataSets.get(itemName);
            for (Object key : dataInHash.keySet()) {
                result = key.toString();
            }
        }
        return result;
    }

    /**
        Retrieve the type of the item (JSON for 1 or XML for 2).
        @param itemName
     */
    public int getType(String itemName) {
        int result = 0;
        if (!checkDataIsPresent(itemName)) {
            HashMap dataInHash = dataSets.get(itemName);
            for (Object key : dataInHash.keySet()) {
                result = Integer.parseInt(dataInHash.get(key).toString());
            }
        }
        return result;
    }

    /**
     *  Remove an item from the repository.
     * @param itemName
     */
    public void deRegister(String itemName) {
        if (!checkDataIsPresent(itemName)) {
            dataSets.remove(itemName);
            System.out.println("Data for " + itemName + " Successfully removed");
        } else {
            System.out.println("Data not Present, Nothing to remove");
        }
    }
}
