package zero.to.mastery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RussianDolls {
    /**
     * Print an integer representing
     * the minimum number of dolls Oleg has after placing
     * all smaller dolls inside the larger dolls
     * Example :
     * 2 2 3 3
     * Output is 2. index 1 with 3. Index 2 with 4
     * 1 2 2 3 4 5
     * Output is 2. index 1,2,4,5 with 6. Index 3 alone.
     */
    public int solve(List<Integer> doll) {
        List<Integer> sortedDoll = doll.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted doll " + sortedDoll);
        int previous = sortedDoll.get(0) - 1;
        int dupCount = 0;
        for (int i = 0; i < sortedDoll.size(); i++) {
            if (sortedDoll.get(i) == previous) {
                dupCount++;
            } else {
                previous = sortedDoll.get(i);
            }
        }
        return dupCount % 2 == 0 ? dupCount : dupCount+1;
    }

    public static void main(String[] args) {
        RussianDolls russianDolls = new RussianDolls();
        List<Integer> dolls = new ArrayList<>();
        dolls.add(2);
        dolls.add(2);
        dolls.add(3);
        dolls.add(3);
        List<Integer> dolls2 = new ArrayList<>();
        dolls2.add(1);
        dolls2.add(2);
        dolls2.add(2);
        dolls2.add(3);
        dolls2.add(4);
        dolls2.add(5);
//        dolls2.add(9);
//        dolls2.add(6);
//        dolls2.add(7);
//        dolls2.add(1);
        System.out.println("Min number of dolls = " + russianDolls.solve(dolls2));
    }
}
