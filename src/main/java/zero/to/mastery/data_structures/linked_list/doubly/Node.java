package zero.to.mastery.data_structures.linked_list.doubly;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node {
    private int value;
    private Node previous;
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
