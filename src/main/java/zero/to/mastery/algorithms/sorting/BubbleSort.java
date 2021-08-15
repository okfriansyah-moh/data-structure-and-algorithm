package zero.to.mastery.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {
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
        System.out.println(bubbleSort(numbers));
        Integer[] array = {8, 1, 56, 4, 7, 1, 87, 0};
        Arrays.stream(bubbleSort(array)).forEach(System.out::println);
    }

    // cara pake list
    private static List<Integer> bubbleSort(List<Integer> data) {
        int arrayLength = data.size();
        int temporal;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength - 1; j++) {
                if (data.get(j) > data.get(j+1)) {
                    // swap numbers
                    temporal = data.get(j);
                    data.set(j, data.get(j+1));
                    data.set(j+1, temporal);
                }
            }
        }
        return data;
    }

    // cara pake array primitive
    public static Integer[] bubbleSort(Integer[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
