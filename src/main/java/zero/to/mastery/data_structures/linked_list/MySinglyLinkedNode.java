package zero.to.mastery.data_structures.linked_list;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MySinglyLinkedNode {
    private int value;
    private MySinglyLinkedNode next;

    public MySinglyLinkedNode(int value) {
        this.value = value;
        this.next = null;
    }
}
