package zero.to.mastery;

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
        return containsManually(s1, s2);
    }

    private boolean containsManually(String s1, String s2) {
        if (s1.length() < s2.length())
            return false;

        int count = 0;

        //Loop until count matches needle length (indicating match) or until we exhaust haystack
        for (int j = 0; j < s1.length() && count < s2.length(); ++j) {
            System.out.println(count);
            if (s1.charAt(j) == s2.charAt(count)) {
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

        return (count == s2.length());
    }

    public static void main(String[] args) {
        IndexOhManually indexOhManually = new IndexOhManually();
        String data = "minum";
        String target = "minam";
        System.out.println(indexOhManually.findIndexOf(data,target));
    }
}
