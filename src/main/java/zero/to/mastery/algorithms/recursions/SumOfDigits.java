package zero.to.mastery.algorithms.recursions;

public class SumOfDigits {
    // How to find the sum of digits of a positive integer number using recursion?
    // Ex : 10 = for the sum is 1 + 0 = 1
    // Ex : 123 = for the sum is 1 + 2 + 3 = 6
    // Ex : 4 = 4
    private static int sumOfDigits(int n) {
        if (n < 0 || n == 0) {
            return 0;
        }
        return n%10 + sumOfDigits(n/10);
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(4));
    }
}
