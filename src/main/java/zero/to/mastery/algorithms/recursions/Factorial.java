package zero.to.mastery.algorithms.recursions;

public class Factorial {

    /* factorial itu perkalian dari n nya
       misal 5! = 5 * 4 * 3 * 2 * 1
     */
    public static void main(String[] args) {
        System.out.println("Factorial of 5 Recursive = " + findFactorialRecursive(5));
        System.out.println("Factorial of 5 Iterative = " + findFactorialIterative(5));

    }

    private static int findFactorialRecursive(int number) {
        if (number == 1) {
            return 1;
        }
        return number * findFactorialRecursive(number-1);
    }

    private static int findFactorialIterative(int number) {
        int answer = 1;
        while (number > 0) {
            answer *= number;
            number--;
        }
        return answer;
    }
}
