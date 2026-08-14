package zero.to.mastery.algorithms.recursions;

/**
 * Demonstrates how to reverse a string using both a recursive strategy and an
 * iterative loop.
 *
 * <p>
 * The recursive version trims the first character and delegates the rest of the
 * work to a smaller substring.
 * Each call re-assembles the string by appending the first character to the end
 * of the reversed remainder.
 * </p>
 *
 * <p>
 * Example:
 * </p>
 * 
 * <pre>
 * reverseStringRecursion("saya opi") -> "ipo ayas"
 * </pre>
 *
 * <p>
 * The iterative variant is often easier to understand in practice and avoids
 * the recursive stack overhead.
 * </p>
 */
public class ReverseStringRecursion {
    /**
     * Shows both implementations in a single console example.
     *
     * <p>
     * Example output:
     * </p>
     * 
     * <pre>
     * Reverse String recursion saya opi = ipo ayas
     * Reverse String iterative saya opi = ipo ayas
     * </pre>
     *
     * @param args command-line arguments; not used by this example
     */
    public static void main(String[] args) {
        System.out.println("Reverse String recursion saya opi = " + reverseStringRecursion("saya opi"));
        System.out.println("Reverse String iterative saya opi = " + reverseStringIterative("saya opi"));
    }

    /**
     * Reverses a string by recursively stripping the first character and processing
     * the remaining substring.
     *
     * <p>
     * The base case is an empty string, which is returned as-is. For any non-empty
     * input, the method calls
     * itself with {@code string.substring(1)} and then appends the first character
     * at the end of the reversed tail.
     * This effectively reverses the ordering of characters without mutating the
     * original string.
     * </p>
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * reverseStringRecursion("abc") -> "cba"
     * </pre>
     *
     * @param string the input string to reverse
     * @return the reversed string
     */
    private static String reverseStringRecursion(String string) {
        if (string.length() == 0) {
            return "";
        }
        return reverseStringRecursion(string.substring(1)) + string.charAt(0);
    }

    /**
     * Reverses a string by iterating from the end of the original text toward the
     * beginning.
     *
     * <p>
     * Instead of recursively calling itself, this implementation uses a
     * {@link StringBuilder}. For each index,
     * it appends the current character from the back of the input string. This
     * makes the algorithm straightforward
     * and avoids the extra stack depth used by recursion.
     * </p>
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * reverseStringIterative("abc") -> "cba"
     * </pre>
     *
     * @param string the input string to reverse
     * @return the reversed string
     */
    private static String reverseStringIterative(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            result.append(string.charAt(string.length() - 1 - i));
        }
        return result.toString();
    }
}
