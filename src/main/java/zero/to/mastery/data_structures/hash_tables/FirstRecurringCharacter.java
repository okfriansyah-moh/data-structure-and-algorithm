package zero.to.mastery.data_structures.hash_tables;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Demonstrates first recurring character concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class FirstRecurringCharacter {

    // Method 1
    /**
     * Executes get first recurring object logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param inputArray input value used by the get first recurring object process
     * @return computed object result produced by the get first recurring object process
     */
    public static Object getFirstRecurringObject(Object[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if(inputArray[i].equals(inputArray[j])) {
                    return inputArray[i];
                }
            }
        }
        return null;
    }

    // Method 2
    /**
     * Executes get first recurring object better logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param inputArray input value used by the get first recurring object better process
     * @return computed object result produced by the get first recurring object better process
     */
    public static Object getFirstRecurringObjectBetter(Object[] inputArray) {
        HashSet<Object> map = new HashSet<>();
        for (Object obj : inputArray) {
            if(map.contains(obj)) {
                return obj;
            } else {
                map.add(obj);
            }
        }
        return null;
    }

    // Method 2-1
    /**
     * Executes first recurring character logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param array input value used by the first recurring character process
     * @return computed integer result produced by the first recurring character process
     */
    private Integer firstRecurringCharacter(int[] array) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int element : array) {
            if (hashSet.contains(element)) {
                return element;
            } else {
                hashSet.add(element);
            }
        }
        return null;
    }

    // Method 3
    /**
     * Executes get first recurring object better2 logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param inputArray input value used by the get first recurring object better2 process
     * @return computed object result produced by the get first recurring object better2 process
     */
    public static Object getFirstRecurringObjectBetter2(Object[] inputArray) {
        HashSet<Object> map = new HashSet<>(Arrays.asList(inputArray)); //Filling the hash table before checking if the item exist
        for (Object obj : inputArray) {
            if (map.contains(obj)) {
                return obj;
            }
        }
        return null;
    }

    /**
     * Executes main logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String[] args) {
        Object[] arr = {1,5,8,5,1,8,8,7,4,4,10};
        System.out.println(getFirstRecurringObjectBetter(arr));
        System.out.println(getFirstRecurringObjectBetter2(arr));
        System.out.println(getFirstRecurringObject(arr));
    }
}
