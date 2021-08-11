package zero.to.mastery.data_structures.linked_list.singly;

import java.util.Collections;
import java.util.LinkedList;

public class JavaLinkedList {

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
    private static void reverse2(LinkedList<Integer> data) {
        Collections.reverse(data);
        System.out.println(data);
    }
}
