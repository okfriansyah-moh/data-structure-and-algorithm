package zero.to.mastery.data_structures.arrays;

/**
 * Demonstrates reverse string concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class ReverseString {

    // reverse method 1
    /**
     * Executes reverse string1 logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param string input value used by the reverse string1 process
     * @return computed string result produced by the reverse string1 process
     */
    private static String ReverseString1(String string) {
        String result = ""; //It's more recommended to use "StringBuilder" object when manipulating strings
        final int length = string.length();
        for (int i = length - 1; i >= 0; i--) {
            result += string.charAt(i);
        }
        return result;
    }

    // reverse method 2
    /**
     * Executes reverse string2 logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param string input value used by the reverse string2 process
     * @return computed string result produced by the reverse string2 process
     */
    private static String ReverseString2(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    // reverse method 3
    /**
     * Executes reverse string3 logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param string input value used by the reverse string3 process
     * @return computed string result produced by the reverse string3 process
     */
    private static String ReverseString3(String string) {
        StringBuilder temp = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            temp.append(string.charAt(i));
        }
        return temp.toString();
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
        System.out.println(ReverseString1("my name is opy"));
        System.out.println(ReverseString2("my name is ana"));
        System.out.println(ReverseString3("my name is zada"));
    }
}
