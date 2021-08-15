package zero.to.mastery.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {
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
        System.out.println(selectionSort(numbers));
        Integer[] array = {5, 1, 85, 4, 7, 9, 0, 3, 1};
        Arrays.stream(selectionSort(array)).forEach(System.out::println);
    }

    // using list
    private static List<Integer> selectionSort(List<Integer> data) {
        int arrayLength = data.size();
        int temporal;
        for (int i = 0; i < arrayLength; i++) {
            int min = i;
            temporal = data.get(i);
            for (int j = i+1; j < arrayLength; j++) {
                if (data.get(j) < data.get(min)) {
                    // update minimum if current is lower
                    // that what we had previously
                    min = j;
                }
            }
            data.set(i, data.get(min));
            data.set(min, temporal);
        }
        return data;
    }

    // using array
    public static Integer[] selectionSort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            int minValue = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (minValue > array[j]) { //Searching min value and it's index
                    minValue = array[j];
                    minIndex = j;
                }
            }
            int temp = array[i]; //Swapping the min value found
            array[i] = minValue;
            array[minIndex] = temp;
        }
        return array;
    }
}
