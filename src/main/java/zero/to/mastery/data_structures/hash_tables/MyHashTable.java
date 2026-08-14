package zero.to.mastery.data_structures.hash_tables;


import java.util.ArrayList;
import java.util.List;

/**
 * A custom hash table implementation demonstrating the core concepts of hash maps.
 * This hash table uses an array of buckets with chaining to handle collisions.
 *
 * <p><b>Key Concepts:</b></p>
 * <ul>
 *   <li><b>Hash Function:</b> Converts string keys to array indices</li>
 *   <li><b>Collision Handling:</b> Uses chaining with ArrayList buckets</li>
 *   <li><b>Average Time Complexity:</b> O(1) for get/set/delete</li>
 *   <li><b>Worst Case:</b> O(n) if all keys hash to the same bucket</li>
 * </ul>
 *
 * <p><b>Architecture:</b></p>
 * <pre>
 * Hash Table with size 5:
 * 
 * Index 0: ["name" → "Alice", "age" → 30]  ← Multiple key-value pairs in same bucket
 * Index 1: []
 * Index 2: ["city" → "NYC"]
 * Index 3: ["country" → "USA"]
 * Index 4: []
 * </pre>
 *
 * <p><b>How Hash Function Works:</b></p>
 * For key "ta":
 * <ul>
 *   <li>t = 116 (ASCII), 116 * 0 = 0</li>
 *   <li>a = 97 (ASCII), 97 * 1 = 97</li>
 *   <li>hash = (0 + 97) % 50 = 47</li>
 * </ul>
 *
 * <p><b>Example Usage:</b></p>
 * <pre>
 * MyHashTable table = new MyHashTable(50);
 * table.set("username", 1000);      // Store value at hashed index
 * int value = table.get("username"); // Retrieve value: 1000
 * List<String> allKeys = table.keys(); // Get all stored keys
 * </pre>
 */
public class MyHashTable {

    private static class MyMapForHashs extends ArrayList<MyMapForHash> {
    }

    private final int length;
    private MyMapForHashs[] data;

    /**
     * Creates a new hash table with the specified size.
     * The size determines how many buckets (sub-arrays) the table has.
     * Larger size generally means fewer collisions, but uses more memory.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Initialize length to the desired size</li>
     *   <li>Create an array of MyMapForHashs (which are ArrayLists)</li>
     *   <li>Each index in the data array can hold multiple key-value pairs (chaining)</li>
     * </ol>
     *
     * <p><b>Example:</b></p>
     * <pre>
     * MyHashTable table = new MyHashTable(50);
     * // Creates 50 empty buckets, each ready to store key-value pairs
     * // table.data = [[], [], [], ..., []]  (50 empty buckets)
     * </pre>
     *
     * <p><b>Size Recommendations:</b></p>
     * <ul>
     *   <li>Too small (e.g., 5 for 100 items): High collision rate, slower lookups</li>
     *   <li>Optimal: Size ≈ 1.3 × expected number of items</li>
     *   <li>Too large (e.g., 1000 for 10 items): Wasted memory</li>
     * </ul>
     *
     * @param size the number of buckets (hash table capacity)
     */
    public MyHashTable(int size) {
        length = size;
        data = new MyMapForHashs[length];  // Initialize array of buckets
    }

    /**
     * Stores a key-value pair in the hash table.
     * If the key already exists, this method will add a duplicate entry
     * (in a real implementation, it would overwrite the old value).
     * Time Complexity: O(1) average case, O(n) worst case (if many collisions).
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Hash the key to get a bucket index</li>
     *   <li>If the bucket is empty, create a new ArrayList</li>
     *   <li>Add the key-value pair to that bucket</li>
     * </ol>
     *
     * <p><b>Example:</b></p>
     * <pre>
     * MyHashTable table = new MyHashTable(50);
     * 
     * table.set("ta", 1000);
     * // hash("ta") = 47
     * // Bucket 47: [("ta", 1000)]
     * 
     * table.set("tu", 589);
     * // hash("tu") = 23  (different bucket)
     * // Bucket 23: [("tu", 589)]
     * 
     * table.set("ta", 2000);
     * // hash("ta") = 47 (same bucket as first "ta")
     * // Bucket 47: [("ta", 1000), ("ta", 2000)]  ← Now has two entries!
     * </pre>
     *
     * <p><b>Collision Example:</b></p>
     * <p>If two different keys hash to the same bucket, they're stored together
     * in the same ArrayList. The get() method searches through the bucket
     * to find the matching key.</p>
     *
     * @param key the string key to store
     * @param value the integer value associated with the key
     */
    public void set(String key, int value) {
        if (data[hash(key)] == null) {
            data[hash(key)] = new MyMapForHashs();  // Create bucket if it doesn't exist
        }
        data[hash(key)].add(new MyMapForHash(key, value));  // Add to bucket
    }

    /**
     * Retrieves the value associated with a given key.
     * If the key doesn't exist, returns 0 (since values are integers).
     * Time Complexity: O(1) average case, O(n) worst case (if many items in same bucket).
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Hash the key to find the bucket index</li>
     *   <li>If bucket is empty, return 0 (key not found)</li>
     *   <li>Search through the bucket for matching key</li>
     *   <li>Return the value if found, otherwise return 0</li>
     * </ol>
     *
     * <p><b>Example with Collisions:</b></p>
     * <pre>
     * After these operations:
     * table.set("ta", 1000);
     * table.set("ta", 2000);  ← Collision! Same key in bucket 47
     * table.set("tu", 589);
     * 
     * table.get("ta");   → Returns 1000 (first match found)
     * table.get("tu");   → Returns 589
     * table.get("xyz");  → Returns 0 (not found)
     * 
     * Note: Since set() doesn't check for duplicate keys,
     * get() returns the first value found for that key.
     * A proper implementation would update instead of append.
     * </pre>
     *
     * <p><b>Bucket Contents:</b></p>
     * <pre>
     * Bucket 47 contains: [("ta", 1000), ("ta", 2000), ...]
     * The loop searches for key "ta" and returns 1000 when found.
     * </pre>
     *
     * @param key the string key to look up
     * @return the integer value associated with the key, or 0 if not found
     */
    public int get(String key) {
        if (data[hash(key)] == null) {
            return 0;  // Bucket doesn't exist, key not found
        }
        // Search through all entries in this bucket
        for (MyMapForHash node : data[hash(key)]) {
            if (node.getKey().equals(key)) {
                return node.getValue();  // Found matching key
            }
        }
        return 0;  // Key not found in bucket
    }

    /**
     * Returns all keys stored in the hash table.
     * Iterates through all buckets and collects every key.
     * Time Complexity: O(n) where n is the total number of key-value pairs.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Create an empty list to collect keys</li>
     *   <li>Loop through each bucket in the hash table</li>
     *   <li>If bucket exists, loop through all entries in that bucket</li>
     *   <li>Collect each key into the result list</li>
     *   <li>Return the list of all keys</li>
     * </ol>
     *
     * <p><b>Example:</b></p>
     * <pre>
     * MyHashTable table = new MyHashTable(50);
     * table.set("ta", 1000);
     * table.set("tu", 589);
     * table.set("e", 10);
     * 
     * List<String> allKeys = table.keys();
     * // Result: ["ta", "tu", "e"]  (order may vary)
     * // Size: 3
     * </pre>
     *
     * <p><b>With Collisions:</b></p>
     * <pre>
     * table.set("ta", 1000);
     * table.set("ta", 2000);  ← Both added to bucket 47
     * 
     * List<String> allKeys = table.keys();
     * // Result: ["ta", "ta"]  (both entries are separate)
     * // Note: In a real hash table, duplicate keys would be overwritten
     * </pre>
     *
     * @return a list containing all keys in the hash table
     */
    public List<String> keys() {
        List<String> keys = new ArrayList<>();
        // Iterate through all buckets
        for (int i = 0; i < length; i++) {
            if (data[i] != null) {
                // Iterate through all entries in this bucket
                for (int j = 0; j < data[i].size(); j++) {
                    keys.add(data[i].get(j).getKey());
                }
            }
        }
        return keys;
    }

    /**
     * Converts a string key into a bucket index using a simple hash function.
     * This is a basic hash function for educational purposes; production systems use more sophisticated ones.
     * Time Complexity: O(k) where k is the length of the key string.
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>Initialize hash to 0</li>
     *   <li>For each character in the key, multiply it by its position and add to hash</li>
     *   <li>Apply modulo with table length to get bucket index (0 to length-1)</li>
     * </ol>
     *
     * <p><b>Detailed Example: hash("ta") with length=50</b></p>
     * <pre>
     * Iteration 1: i=0, character='t' (ASCII 116)
     *   hash = (0 + 116 * 0) % 50 = 0
     * 
     * Iteration 2: i=1, character='a' (ASCII 97)
     *   hash = (0 + 97 * 1) % 50 = 97 % 50 = 47
     * 
     * Result: Bucket index = 47
     * </pre>
     *
     * <p><b>More Examples with length=50:</b></p>
     * <pre>
     * hash("a"):   (97 * 0) % 50 = 0
     * hash("ab"):  (97 * 0 + 98 * 1) % 50 = 98 % 50 = 48
     * hash("ba"):  (98 * 0 + 97 * 1) % 50 = 97 % 50 = 47
     * hash("tu"):  (116 * 0 + 117 * 1) % 50 = 117 % 50 = 17
     * </pre>
     *
     * <p><b>Important Notes:</b></p>
     * <ul>
     *   <li>Different keys can hash to the same bucket (collision)</li>
     *   <li>The modulo operation ensures the result is always within valid bucket range</li>
     *   <li>This simple function isn't perfect; a good hash distributes keys evenly</li>
     *   <li>Real hash tables use cryptographic or specialized hash functions</li>
     * </ul>
     *
     * @param key the string key to hash
     * @return a bucket index between 0 and length-1
     */
    private int hash(String key) {
        int hash = 0;
        // For each character, multiply by position and add to running hash
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i) * i) % length;
        }
        return hash;
    }

    /**
     * Demonstrates the core operations of a hash table: storing and retrieving values.
     * This example shows how to create a hash table, store multiple key-value pairs,
     * and then retrieve them.
     *
     * <p><b>Expected Output:</b></p>
     * <pre>
     * 3              ← Number of keys stored
     * 1000           ← Value for "ta"
     * 589            ← Value for "tu"
     * 10             ← Value for "e"
     * </pre>
     *
     * <p><b>Step-by-step execution:</b></p>
     * <pre>
     * 1. Create hash table with 50 buckets
     * 2. Store ("ta", 1000) at hash index 47
     * 3. Store ("tu", 589) at hash index 17
     * 4. Store ("e", 10) at hash index 10
     * 5. Print number of unique keys: 3
     * 6. Retrieve and print each value
     * </pre>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        MyHashTable table = new MyHashTable(50);
        table.set("ta", 1000);
        table.set("tu", 589);
        table.set("e", 10);
        System.out.println(table.keys().size());   // Print: 3 keys
        System.out.println(table.get("ta"));       // Print: 1000
        System.out.println(table.get("tu"));       // Print: 589
        System.out.println(table.get("e"));        // Print: 10
    }
}
