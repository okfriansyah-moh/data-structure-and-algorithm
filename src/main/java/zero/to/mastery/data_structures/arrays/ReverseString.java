package zero.to.mastery.data_structures.arrays;

public class ReverseString {
    // reverse method 1
    private static String ReverseString1(String string) {
        String result = ""; //It's more recommended to use "StringBuilder" object when manipulating strings
        final int length = string.length();
        for (int i = length - 1; i >= 0; i--) {
            result += string.charAt(i);
        }
        return result;
    }

    // reverse method 2
    private static String ReverseString2(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    // reverse method 3
    private static String ReverseString3(String string) {
        StringBuilder temp = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            temp.append(string.charAt(i));
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseString1("my name is opy"));
        System.out.println(ReverseString2("my name is ana"));
        System.out.println(ReverseString3("my name is zada"));
    }
}
