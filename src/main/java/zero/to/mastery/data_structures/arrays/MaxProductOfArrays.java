package zero.to.mastery.data_structures.arrays;

public class MaxProductOfArrays {
    // Max Product
    public String maxProduct(int[] intArray) {
        int maxProduct = 0;
        String pairs = "";
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i+1; j < intArray.length; j++) {
                if (intArray[i] * intArray[j] > maxProduct) {
                    maxProduct = intArray[i] * intArray[j];
                    pairs = Integer.toString(intArray[i]) + "," + Integer.toString(intArray[j]);
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        MaxProductOfArrays maxProductOfArrays = new MaxProductOfArrays();
        int[] intArray = {10,20,30,40,50};
        String pairs = maxProductOfArrays.maxProduct(intArray);
        System.out.println(pairs);
    }
}
