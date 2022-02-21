package zero.to.mastery.data_structures.arrays;

import java.util.ArrayList;
import java.util.List;

public class IntegerCheckDuplicate {

    // O(n^2) approach
    List<Integer> data = new ArrayList<>();
    public boolean isUnique2(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i+1; j < intArray.length; j++) {
                if (intArray[i] == intArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // O(n) approach
    public boolean isUnique(int[] intArray) {
        // TODO
        int temp = 0;
        for (int i : intArray) {
            if (i == temp) {
                return false;
            }
            temp = i;
        }
        return true;
    }

    public static void main(String[] args) {
        IntegerCheckDuplicate integerCheckDuplicate = new IntegerCheckDuplicate();
        int[] intArray = {1,2,3,4,5,6,6};
        System.out.println(integerCheckDuplicate.isUnique(intArray));
    }
}
