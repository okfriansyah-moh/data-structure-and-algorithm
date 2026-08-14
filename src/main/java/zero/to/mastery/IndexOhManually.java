package zero.to.mastery;

/**
 * Demonstrates index oh manually concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class IndexOhManually {

    /**
     * Executes find index of logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param data input value used by the find index of process
     * @param target input value used by the find index of process
     * @return computed int result produced by the find index of process
     */
    public int findIndexOf(String data, String target) {
        if ( target.length() <= 0
                || data.length() <= 0
                || !contains(data, target)) return -1;
        int dataLength = data.length();
        char findData = target.charAt(0);
        int counter = 0;
        while (counter < dataLength) {
            if (data.charAt(counter) == findData) {
                break;
            }
            counter++;
        }
        return counter;
    }

    /**
     * Executes contains logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param s1 input value used by the contains process
     * @param s2 input value used by the contains process
     * @return computed boolean result produced by the contains process
     */
    public boolean contains(String s1, String s2) {
        return containsManually(s1, s2);
    }

    /**
     * Executes contains manually logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param s1 input value used by the contains manually process
     * @param s2 input value used by the contains manually process
     * @return computed boolean result produced by the contains manually process
     */
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

    /**
     * Executes main logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String[] args) {
        IndexOhManually indexOhManually = new IndexOhManually();
        String data = "12345";
        String target = "2";
        System.out.println(indexOhManually.findIndexOf(data,target));
    }
}
