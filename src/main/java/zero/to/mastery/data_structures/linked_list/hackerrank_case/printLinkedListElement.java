package zero.to.mastery.data_structures.linked_list.hackerrank_case;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Demonstrates print linked list element concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class printLinkedListElement {
    /**
     * Executes main logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
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
