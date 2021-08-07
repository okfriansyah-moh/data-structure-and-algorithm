package zero.to.mastery.data_structures.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HackerRankArraysCase {

    //Common array function, to convert int into an array
    private void convertIntegToArra() {
        int number = 110101;
        String temp = Integer.toString(number);
        int[] numbers = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            numbers[i] = temp.charAt(i) - '0';
        }
    }

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     * a b c
         d
       e f g
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        Integer result = Integer.MIN_VALUE;
        int total = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                total = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2);
                total += arr.get(i+1).get(j+1);
                total += arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
                result = total > result ? total : result;
            }
        }

        return result;
    }

    // Left Rotation problem based on n. n is consist of size array and how much rotate to left
    // Array.push    -> ArrayList.add(Object o); // Append the list
    //Array.pop     -> ArrayList.remove(int index); // Remove list[index]
    //Array.shift   -> ArrayList.remove(0); // Remove first element
    //Array.unshift -> ArrayList.add(int index, Object o); // Prepend the list
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        // remove first add last
        int data = 0;
        int arrLength = arr.size();
        for (int i = 0; i < d; i++) {
            data = arr.get(0);
            System.out.println(data);
            arr.remove(0);
            // arr.remove(i);
            System.out.println(arr.toString());
            arr.add(arrLength - 1, data);
            System.out.println(arr.toString());
        }
        return arr;

    }

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     *
     *  Jadi ada list of strings misalnya ada 5 random string, trus ada queries random string.
     * Dibandingin dah seberapa banyak data yg ada di queries terhadap yang ada di strings
     *
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        int iterasi = 0;
        int countOccurence = 0;
        for (int i = 0; i < queries.size(); i++) {
            for (int j=0; j < strings.size(); j++) {
                System.out.println(queries.get(i) + " equals to " + strings.get(j));
                if (queries.get(i).equals((strings.get(j)))) {
                    countOccurence++;
                }
            }
            result.add(countOccurence);
            countOccurence = 0;
            iterasi++;
        }
        List<List<Integer>> firstIteration = new ArrayList<>();
        firstIteration.get(0);
        return result;

    }

    // HARD array case in HR
    //2,4,7 = b+1 = 5
    //        1,3,1 = b+1 = 4
    //                3,5,13 = b+1 = 6
    // n = 5
    // 0 7 0 0 -7
    // 1 0 0 -1 0
    // 0 0 13 0 0
    // 1 7 13 -1 -7
    // 1 8 21 20 13
    // https://www.youtube.com/watch?v=JtJKn_c9lB4


    // Print even and odd case in java
    private void javaCaseHR() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if ((n % 2 == 1) || (n % 2 == 0 && n >= 6 && n <= 20)) {
                System.out.println("Weird");
            } else if ((n % 2 == 0 && n >= 2 && n <= 5) || (n % 2 == 0 && n > 20)) {
                System.out.println("Not Weird");
            }
        }
    }
}