package zero.to.mastery;

public class BulbSwitcher3PrefixAligned {
    public int numTimesAllBlue(int[] flips) {
        String binary = "";
        int result = 0;
        int counter = 0;
        while (counter < flips.length) {
            binary += counter + "";
            counter++;
        }
        int index = 0;
        String binary2 = "";
        for (int i : flips) {
            binary2 += "1";
            binary = binary.replace(i-1 + "", "1");
            System.out.println("Real binary = " + binary);
            System.out.println("binary substring = " + binary.substring(0, index+1));
            System.out.println("binary 2 = " + binary2);
            if (check(binary,index,binary2)) {
                result++;
            }
            index ++;
        }
        return result;
    }

    private boolean check(String binary, int index, String binary2) {
        int indexCheck = index+1;
        if (binary.substring(0, indexCheck).equals(binary2)) {
            if (binary.length() - indexCheck != 0) {
                int endCheck = indexCheck+1;
                boolean equals = binary.substring(indexCheck, endCheck).equals("1");
                if (equals) {
                    System.out.println("binary check = " + binary.substring(indexCheck, endCheck));
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int numTimesAllBlue2(int[] flips) {
        int sum1=0, sum2=0, count=0;
        for(int i=0;i<flips.length;i++){
            sum1 = sum1 + flips[i];
            System.out.println("sum1 = " + sum1);
            sum2 = sum2 + (i+1);   //i+1 beacause of 1 based idxing
            System.out.println("sum2 = " + sum2);
            if(sum1==sum2) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] intArray = {4,1,2,3};
        BulbSwitcher3PrefixAligned bulbSwitcher3PrefixAligned = new BulbSwitcher3PrefixAligned();
        System.out.println(bulbSwitcher3PrefixAligned.numTimesAllBlue(intArray));
    }
}
