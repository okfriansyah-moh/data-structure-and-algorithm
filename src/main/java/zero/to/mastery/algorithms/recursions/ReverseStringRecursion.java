package zero.to.mastery.algorithms.recursions;

/**
 * Demonstrates reverse string recursion concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class ReverseStringRecursion {
    /**
     * Executes main logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String[] args) {
        System.out.println("Reverse String recursion saya opi = " + reverseStringRecursion("saya opi"));
        System.out.println("Reverse String iterative saya opi = " + reverseStringIterative("saya opi"));
    }

    /**
     * Executes reverse string recursion logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param string input value used by the reverse string recursion process
     * @return computed string result produced by the reverse string recursion process
     */
    private static String reverseStringRecursion(String string) {
        if(string.length() == 0) {
            return "";
        }
        return reverseStringRecursion(string.substring(1)) + string.charAt(0);
    }

    /**
     * Executes reverse string iterative logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param string input value used by the reverse string iterative process
     * @return computed string result produced by the reverse string iterative process
     */
    private static String reverseStringIterative(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            result.append(string.charAt(string.length() - 1 - i));
        }
        return result.toString();
    }
}
