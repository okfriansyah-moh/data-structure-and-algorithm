package zero.to.mastery.data_structures.arrays;

import java.util.Scanner;

public class CalculateTempArray {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many days temp ? ");
        int numDays = scanner.nextInt();
        int temp = scanner.nextInt();
        CalculateTempArray calculateTempArray = new CalculateTempArray();
        calculateTempArray.calcTemp(numDays, temp);
    }
}
