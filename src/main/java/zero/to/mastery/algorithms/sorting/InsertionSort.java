package zero.to.mastery.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(44);
        numbers.add(6);
        numbers.add(2);
        numbers.add(1);
        numbers.add(5);
        numbers.add(63);
        numbers.add(87);
        numbers.add(283);
        numbers.add(4);
        numbers.add(0);
        System.out.println(InsertionSort(numbers));
        Integer[] array = {1, 8, 54, 9, 65, 1, 100, 0, 45};
        Arrays.stream(insertionSort2(array)).forEach(System.out::println);
    }

    // using list cara 1
    private static List<Integer> InsertionSort(List<Integer> data) {
        int arrayLength = data.size();
        for (int i = 0; i < arrayLength; i++) {
            // move number to the first position
            if (data.get(i) <= data.get(0)) {
                data.add(0, data.get(i));
                data.remove(i+1);
            } else {
            // find where number shpuld go
                for (int j = 1; j < i; j++) {
                    if (data.get(i) > data.get(j-1)
                    && data.get(i) < data.get(j)) {
            // move number to the right spot
                        data.add(j, data.get(i));
                        data.remove(i+1);
                    }
                }
             }
        }
        return data;
    }

    // using array cara 2
    public static Integer[] insertionSort2(Integer[] array) {
        List<Integer> list = new LinkedList<>(Arrays.asList(array)); //Using linked list so shifting will be efficient
        for (int i = 1; i < list.size(); i++) { //Fixed: i start at i = 1
            if (list.get(i) <= list.get(0)) { //Fixed: duplicate values sort by changing  to "<="
                //Checking if current number is suppose to be first
                list.add(0, list.get(i)); //Moving the number to first position
                list.remove(i + 1);
            } else {
                // only sort number smaller than number on the left of it.
                // This is the part of insertion sort that makes it fast
                // if the array is almost sorted.
                if (list.get(i) < list.get(i - 1)) {
                    //find where number should go
                    for (int j = 1; j < i; j++) {
                        if (list.get(i) >= list.get(j - 1) && list.get(i) < list.get(j)) {
                            //move number to the correct spot
                            list.add(j, list.get(i));
                            list.remove(i + 1);
                        }
                    }
                }
            }
        }
        return list.toArray(new Integer[0]);
    }

}
