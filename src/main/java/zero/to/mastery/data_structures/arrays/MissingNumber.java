package zero.to.mastery.data_structures.arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int intArray[] = {1,2,3,4,5,6,7,9,10,11,13,14};
        MissingNumber m = new MissingNumber();
        m.missingNumber(intArray);
    }

    public void missingNumber(int[] intArray) {
        int missingNumber = 0;
        for (int i = 1; i < intArray.length; i++) {
            System.out.println(i + " not " + intArray[i-1]);
            if(i != intArray[i-1]) {
                missingNumber = i;
                break;
            }
        }
        System.out.println("Missing Number is " + missingNumber);
    }
}
