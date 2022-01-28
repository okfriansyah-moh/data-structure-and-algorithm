package zero.to.mastery.data_structures;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChar {

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
        System.out.println("Result = "+longestSubstringWithoutRepeatingChar.lengthOfLongestSubstringOptimize(emptySpace));
    }
}
