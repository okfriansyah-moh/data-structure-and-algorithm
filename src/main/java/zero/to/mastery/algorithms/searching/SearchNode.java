package zero.to.mastery.algorithms.searching;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchNode {
    private int value;
    private SearchNode left;
    private SearchNode right;

    public SearchNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
