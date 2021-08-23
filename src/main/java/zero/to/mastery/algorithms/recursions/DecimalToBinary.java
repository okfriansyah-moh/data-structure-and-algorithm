package zero.to.mastery.algorithms.recursions;

public class DecimalToBinary {
    // rumus decimal to binary
    // n mod 2 + 10 * f(n/2)
    private static int decimalToBinary(int n) {
        if (n == 0) {
            return 0;
        }
        return n%2 + 10*decimalToBinary(n/2);
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(10));
    }
}
