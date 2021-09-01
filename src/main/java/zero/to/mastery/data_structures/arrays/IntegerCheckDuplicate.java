package zero.to.mastery.data_structures.arrays;

public class IntegerCheckDuplicate {
    public boolean isUnique(int[] intArray) {
        // TODO
        int temp = 0;
        for (int i : intArray) {
            if (i == temp) {
                return false;
            }
            temp = i;
        }
        return true;
    }

    public static void main(String[] args) {
        IntegerCheckDuplicate integerCheckDuplicate = new IntegerCheckDuplicate();
        int[] intArray = {1,2,3,4,5,6,6};
        System.out.println(integerCheckDuplicate.isUnique(intArray));
    }
}
