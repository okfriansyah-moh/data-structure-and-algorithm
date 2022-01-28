package zero.to.mastery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearchTargetInArray {
    public boolean searchTarget(List<Integer>array, int target) {
        List<Integer> sortedArray = array.stream().sorted().collect(Collectors.toList());
        int left = 0, right = sortedArray.size()-1;
        while (left <= right) {
            var mid = Math.floor((left+right)/2);
            var foundVal = sortedArray.get((int) mid);
            if (foundVal == target) {
                return true;
            } else if (foundVal < target) {
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTargetInArray binarySearchTargetInArray = new BinarySearchTargetInArray();
        List<Integer> ar = new ArrayList<>();
        ar.add(1);
        ar.add(5);
        ar.add(3);
        ar.add(6);
        ar.add(9);
        ar.add(2);
        System.out.println(binarySearchTargetInArray.searchTarget(ar, 4));
    }
}
