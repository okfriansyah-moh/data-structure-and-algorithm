package zero.to.mastery.data_structures.hash_tables;


import java.util.ArrayList;
import java.util.List;

/**
 * This is just an example on how you could write a HashTable as it was shown on the course,
 * this is not how it's implemented in Java, please refer to {@link java.util.HashMap}
 */
public class MyHashTable {

    private static class MyMapForHashs extends ArrayList<MyMapForHash> {
    }

    private final int length;
    private MyMapForHashs[] data;

    /**
     * Creates a new {@code MyHashTable} instance for my hash table operations.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param size input value used by the my hash table process
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public MyHashTable(int size) {
        length = size;
        data = new MyMapForHashs[length];
    }

    /**
     * Executes set logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param key input value used by the set process
     * @param value input value used by the set process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void set(String key, int value) {
        if (data[hash(key)] == null) {
            data[hash(key)] = new MyMapForHashs();
        }
        data[hash(key)].add(new MyMapForHash(key, value));
    }

    /**
     * Executes get logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param key input value used by the get process
     * @return computed int result produced by the get process
     */
    public int get(String key) {
        if (data[hash(key)] == null) {
            return 0;
        }
        for (MyMapForHash node : data[hash(key)]) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return 0;
    }

    /**
     * Executes keys logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @return computed list<string> result produced by the keys process
     */
    public List<String> keys() {
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (data[i] != null) {
                for (int j = 0; j < data[i].size(); j++) {
                    keys.add(data[i].get(j).getKey());
                }
            }
        }
        return keys;
    }

    /**
     * Executes hash logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param key input value used by the hash process
     * @return computed int result produced by the hash process
     */
    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i) * i) % length;
        }
        return hash;
    }

    /**
     * Executes main logic.
     *
     * <p>Explanation: this routine is part of the learning implementation and follows the algorithmic
     * steps defined in this class.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String[] args) {
        MyHashTable table = new MyHashTable(50);
        table.set("ta", 1000);
        table.set("tu", 589);
        table.set("e", 10);
        System.out.println(table.keys().size());
        System.out.println(table.get("ta"));
        System.out.println(table.get("tu"));
        System.out.println(table.get("e"));
    }
}
