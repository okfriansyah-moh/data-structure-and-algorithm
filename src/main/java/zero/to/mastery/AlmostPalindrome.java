package zero.to.mastery;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        String regions = "[\"BCA\", \"Mandiri\", \"BNI\"]";
        System.out.println(" regions String List --------" + regions);

        System.out.println("  --------   " );
        System.out.println("  --------   " );

        String region2 = new Gson().toJson(regions);
        System.out.println(" String lansung dengan new Gson--------" + region2);
        String region3 = region2.substring(1,region2.length()-1);
        System.out.println(" String dengan subString  --------" + region3);

        System.out.println("  --------   " );
        System.out.println("  --------   " );

        List<String> regions33 = List.of(region3.split(","));
        String[] regions3 = region3.split(",");
        System.out.println(" String[] jika lansung split  --------" + new Gson().toJson(regions33));
        List<String> regions6 = new ArrayList<>();
        for (int i = 0; i< regions3.length; i++){
            regions6.add(regions3[i].substring(1,regions3[i].length()-1));
        }
        String[] regions7 = regions6.toArray(new String[0]);
        System.out.println(" String[] setelah di subString --------" + new Gson().toJson(regions7));
    }
}
