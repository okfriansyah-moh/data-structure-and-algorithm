package zero.to.mastery.data_structures;

import java.util.HashMap;

/**
 * Demonstrates longest substring without repeating char concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class LongestSubstringWithoutRepeatingChar {

    /**
     * Executes length of longest substring optimize logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param s input value used by the length of longest substring optimize process
     * @return computed int result produced by the length of longest substring optimize process
     */
    public int lengthOfLongestSubstringOptimize(String s) {
        if (s.length() <= 1) return s.length();
        HashMap<Character, Integer> seenChars = new HashMap<>();
        int left = 0, longest = 0;
        for (int right = 0 ; right < s.length(); right++) {
            var currentChar = s.charAt(right);
            var prevSeenChar = seenChars.get(currentChar);
            if (prevSeenChar != null && prevSeenChar >= left) {
                left = prevSeenChar + 1;
            }
            seenChars.put(currentChar, right);
            longest = Math.max(longest, right-left+1);
        }
        return longest;
    }

    /**
     * Executes length of longest substring using while logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param s input value used by the length of longest substring using while process
     * @return computed int result produced by the length of longest substring using while process
     */
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

    /**
     * Executes main logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String[] args) {
        String a = "abcabcbb";
        String b = "pwwkew";
        String emptySpace = "aab";
        LongestSubstringWithoutRepeatingChar longestSubstringWithoutRepeatingChar = new LongestSubstringWithoutRepeatingChar();
        System.out.println("Result = "+longestSubstringWithoutRepeatingChar.lengthOfLongestSubstringOptimize(emptySpace));
    }
}
