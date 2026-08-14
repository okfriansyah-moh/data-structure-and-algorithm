package zero.to.mastery.data_structures.arrays;

import java.util.Scanner;

/**
 * Demonstrates calculate temp array concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class CalculateTempArray {
    /**
     * Executes calc temp logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param numDays input value used by the calc temp process
     * @param temp input value used by the calc temp process
     * Output: updates internal state and/or prints computed results to the console.
     */
    private void calcTemp(int numDays, int temp) {
        int[] temps = new int[numDays];
        int sum = 0;
        for (int i=0; i <= numDays; i++) {
            System.out.println("Day " + i+1 + "'s high temp: ");
            temps[i] = temp;
            sum += temps[i];
        }

        double average = sum / numDays;
        // count days above average
        int above = 0;
        for (int i=0; i < temps.length; i++) {
            if (temps[i] > average) {
                above++;
            }
        }
        System.out.println();
        System.out.println("Average Temp = " + average);
        System.out.println(above + " days above average");
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many days temp ? ");
        int numDays = scanner.nextInt();
        int temp = scanner.nextInt();
        CalculateTempArray calculateTempArray = new CalculateTempArray();
        calculateTempArray.calcTemp(numDays, temp);
    }
}
