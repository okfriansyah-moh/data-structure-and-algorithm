package zero.to.mastery.algorithms.recursions;

public class ReverseStringRecursion {
    public static void main(String[] args) {
        System.out.println("Reverse String recursion saya opi = " + reverseStringRecursion("saya opi"));
        System.out.println("Reverse String iterative saya opi = " + reverseStringIterative("saya opi"));
    }

    private static String reverseStringRecursion(String string) {
        if(string.length() == 0) {
            return "";
        }
        return reverseStringRecursion(string.substring(1)) + string.charAt(0);
    }

    private static String reverseStringIterative(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            result.append(string.charAt(string.length() - 1 - i));
        }
        return result.toString();
    }
}
