package zero.to.mastery.data_structures.hash_tables;

import java.util.Hashtable;
import java.util.Map;

/**
 * Demonstrates java hash tables concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class JavaHashTables {
    /**
     * Executes main logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String[] args) {
        // we can also use HashMap or HashSet.
        Map<String, String> phoneBook = new Hashtable<>();
        // putting keys:values in hashtable phoneBook
        phoneBook.put("Chris", "445454545");
        phoneBook.put("Morris", "4548623233");
        phoneBook.put("Mary", "865656223");

        System.out.println("phoneBook: "+phoneBook);
        //accessing values using keys
        System.out.println("Chris's phoneNo." + phoneBook.get("Chris"));
        //deleting entries using keys
        System.out.println("remove morris: "+phoneBook.remove("Morris"));
        //phoneBook after removing morris
        System.out.println("phoneBook: "+phoneBook);

    }
}
