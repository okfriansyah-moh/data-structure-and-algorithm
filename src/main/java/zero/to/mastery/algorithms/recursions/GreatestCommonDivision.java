package zero.to.mastery.algorithms.recursions;

public class GreatestCommonDivision {
    // what is GCD?
    // GCD itu = greatest common divisor (factor)
    // Contoh : GCD or GCD 54 dan 24 itu berapa?
    // 54 itu bisa dicapai dengan 1 * 54 , 2 * 27, 3 * 18 , 6  * 9
    // Nah 24 itu bisa dicapai dengan 1 * 24, 2 * 12, 3 * 8, 4 * 6,
    // Complete divisor 54 itu 1,2,3,6,9, 18,27,54.
    // Complete divisor 24 itu 1,2,3,4,6,8,12,24.
    // GCD nya 1,2,3,6. Dan yang paling besar itu adalah 6.
    // Maka GCD(54,24) = 6
    private static int gcd(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(8,4));
    }
}
