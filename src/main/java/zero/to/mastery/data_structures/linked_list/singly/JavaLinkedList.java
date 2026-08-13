package zero.to.mastery.data_structures.linked_list.singly;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Demonstrates java linked list concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class JavaLinkedList {

    /**
     * Executes main logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String[] args) {
        LinkedList<Integer> javaLinkedList = new LinkedList<>();
        javaLinkedList.add(5);
        javaLinkedList.add(8);
        javaLinkedList.add(4);
        javaLinkedList.addFirst(10);
        System.out.println(javaLinkedList);
        javaLinkedList.add(2, 15);
        System.out.println(javaLinkedList);
        javaLinkedList.remove(2);
        System.out.println(javaLinkedList);
        System.out.println(reverse(javaLinkedList));
        reverse2(javaLinkedList);
    }

    // reverse cara 1 using while recursive
    /**
     * Executes reverse logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param data input value used by the reverse process
     * @return computed linked list<integer> result produced by the reverse process
     */
    private static LinkedList<Integer> reverse(LinkedList<Integer> data) {
        LinkedList<Integer> reverse = new LinkedList<>();
        int indexLength = data.size() - 1;
        int index = 0;
        while (indexLength >= 0){
            reverse.add(index, data.get(indexLength));
            indexLength--;
            index++;
        }
        return reverse;
    }

    // reverse cara 2 using java util Collections
    /**
     * Executes reverse2 logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param data input value used by the reverse2 process
     * Output: updates internal state and/or prints computed results to the console.
     */
    private static void reverse2(LinkedList<Integer> data) {
        Collections.reverse(data);
        System.out.println(data);
    }
}
