package zero.to.mastery.data_structures.hash_tables;

import java.util.Arrays;
import java.util.HashSet;

public class FirstRecurringCharacter {

    // Method 1
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
    public static Object getFirstRecurringObjectBetter2(Object[] inputArray) {
        HashSet<Object> map = new HashSet<>(Arrays.asList(inputArray)); //Filling the hash table before checking if the item exist
        for (Object obj : inputArray) {
            if (map.contains(obj)) {
                return obj;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Object[] arr = {1,5,8,5,1,8,8,7,4,4,10};
        System.out.println(getFirstRecurringObjectBetter(arr));
        System.out.println(getFirstRecurringObjectBetter2(arr));
        System.out.println(getFirstRecurringObject(arr));
    }
}
