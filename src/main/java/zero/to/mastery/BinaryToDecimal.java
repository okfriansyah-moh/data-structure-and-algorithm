package zero.to.mastery;

import java.math.BigInteger;

/**
 * Demonstrates binary to decimal concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class BinaryToDecimal {
    /**
     * Executes solution logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param S input value used by the solution process
     * @return computed int result produced by the solution process
     */
    public int solution(String S) {
        // write your code in Java SE 11
        BigInteger v = binaryToDecimal(S);
        return howMuchOperationsToCalculateV(v);
    }

    /**
     * Executes how much operations to calculate v logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param v input value used by the how much operations to calculate v process
     * @return computed int result produced by the how much operations to calculate v process
     */
    private int howMuchOperationsToCalculateV(BigInteger v) {
        int counter = 0;
        while (!BigInteger.ZERO.equals(v)) {
            if (v.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
                v = v.divide(new BigInteger("2"));
                counter++;
            } else {
                v = v.subtract(new BigInteger("1"));
                counter++;
            }
        }
        return counter;
    }

    /**
     * Executes binary to decimal logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param s input value used by the binary to decimal process
     * @return computed big integer result produced by the binary to decimal process
     */
    private BigInteger binaryToDecimal(String s) {
        BigInteger n = new BigInteger(s);
        BigInteger result = BigInteger.ZERO;
        int p = 0;
        while(!BigInteger.ZERO.equals(n))
        {
            result = result.add((n.mod(new BigInteger("10"))).multiply(new BigInteger("2").pow(p)));
            n = n.divide(new BigInteger("10"));
            p++;
        }
        return result;
    }

    /**
     * Executes main logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String args[]){
        String binaryString="111111111111111111111111" +
                "1111111111111111111111111111111111111111111111111" +
                "1111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111111111111111111111111111" +
                "1111111111111111111111111111111111111111111111111111111111111" +
                "1111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111" +
                "1111111111111111111111111111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111111" +
                "1111111111111111111111111111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111111111111111111111111" +
                "11111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111" +
                "1111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111" +
                "1111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111111" +
                "111111111111111111111111111111111111111111111111111111111111111" +
                "11111111111111111111";
        BinaryToDecimal binaryToDecimal = new BinaryToDecimal();
        System.out.println(binaryToDecimal.solution(binaryString));
    }

}
