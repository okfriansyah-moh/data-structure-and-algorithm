package zero.to.mastery.data_structures.arrays;

public class FindNumberInArray {
    public int searchInArray(int[] intArray, int valueToSearch) {
        // TODO
        int count = 0;
        for (int i : intArray) {
            if (valueToSearch == i) {
                return count;
            }
            count++;
        }
        throw new IllegalArgumentException("No data found");
    }

    public static void main(String[] args) {
        FindNumberInArray findNumberInArray = new FindNumberInArray();
        int[] intArray = {1,2,3,4,5,6};
        System.out.println(findNumberInArray.searchInArray(intArray, 6));
    }
}
