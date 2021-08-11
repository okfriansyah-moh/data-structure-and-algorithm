package zero.to.mastery.data_structures.linked_list.hackerrank_case;

import java.util.LinkedList;
import java.util.Scanner;

public class printLinkedListElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> data = new LinkedList<>();
        while(scan.hasNext()) {
            int input = scan.nextInt();
            data.add(input);
        }
        data.remove(0);
        data.forEach(System.out::println);
    }
}
