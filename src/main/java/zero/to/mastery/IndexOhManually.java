package zero.to.mastery;

import java.util.HashSet;

public class IndexOhManually {

    public int findIndexOf(String data, String target) {
        int dataLength = data.length();
        char findData = target.charAt(0);
        int counter = 0;
        if (!contains(data, target)) return -1;
        while (counter < dataLength) {
            if (data.charAt(counter) == findData) {
                break;
            }
            counter++;
        }
        return counter;
    }

    public boolean contains(String s1, String s2) {
        return containsManually2(s1, s2);
    }

    private boolean containsManually(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int count = 0;

        //Loop until count matches needle length (indicating match) or until we exhaust haystack
        for (int j = 0; j < s2.length() && count < s1.length(); ++j) {
            if (s1.charAt(count) == s2.charAt(j)) {
                ++count;
            }
            else {
                //Redo iteration to handle adjacent duplicate char case
                if (count > 0)
                    --j;

                //Reset counter
                count = 0;
            }
        }

        return (count == s1.length());
    }

    private boolean containsManually2(String s1, String s2) {
        HashSet<String> validateData = new HashSet<>();
        validateData.add(s2);
        int targetLength = s2.length();
        int subStringFrom = s1.length() - targetLength;
        return validateData.contains(s1.substring(subStringFrom));
    }

    public static void main(String[] args) {
        IndexOhManually indexOhManually = new IndexOhManually();
        String data = "minum";
        String target = "um";
        System.out.println(indexOhManually.findIndexOf(data,target));
    }
}
