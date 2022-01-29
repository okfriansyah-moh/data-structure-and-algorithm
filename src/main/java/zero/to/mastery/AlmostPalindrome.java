package zero.to.mastery;

public class AlmostPalindrome {
    public boolean validPalindrome(String s) { // space O(1) , time O(n)
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validSubPalindrome(s, left+1, right) ||
                        validSubPalindrome(s, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    // find the conflict character and try to remove it to check ,
    // if removing either from left or right, is it a palindrome or not
    private boolean validSubPalindrome(String s , int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
