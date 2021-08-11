package zero.to.mastery.data_structures.linked_list.hackerrank_case;

import java.util.LinkedList;
import java.util.Scanner;

public class insertHead {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> data = new LinkedList<>();
        int iterasi = 0;
        while(scan.hasNext()) {
            int input = scan.nextInt();
            data.addFirst(input);
            if (iterasi == 0) {
                data.remove(0);
            }
            iterasi++;
        }
        data.forEach(System.out::println);
    }
}
