package zero.to.mastery.data_structures;

public class LongestSubstringWithoutRepeatingChar {

        public int lengthOfLongestSubstringUsingWhile(String s) {
        int starter = 0;
        int counter = 0;
        int lastStarter = 0;
        int tempCounter = 0;
        String container = "";
        while (starter < s.length()) {
            if (!container.contains(s.charAt(starter) + "")) {
                container += s.charAt(starter);
                counter++;
                tempCounter = Math.max(counter, tempCounter);
                starter++;
            } else {
                tempCounter = Math.max(container.length(), tempCounter);
                container = "";
                lastStarter++;
                starter = lastStarter;
                counter = 0;
            }
            System.out.println("starter = " + starter);
            System.out.println("container = [" + container + "]");
        }
        return tempCounter;
    }

    public static void main(String[] args) {
        String a = "abcabcbb";
        String b = "pwwkew";
        String emptySpace = "aab";
        LongestSubstringWithoutRepeatingChar longestSubstringWithoutRepeatingChar = new LongestSubstringWithoutRepeatingChar();
        System.out.println("Result = "+longestSubstringWithoutRepeatingChar.lengthOfLongestSubstringUsingWhile(emptySpace));
    }
}
