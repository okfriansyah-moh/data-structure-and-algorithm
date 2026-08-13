package zero.to.mastery.data_structures.graph;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Demonstrates adjacent undirected unweighted concepts for data-structure and algorithm practice.
 *
 * <p>Use this class as a quick reference for the core algorithm flow.</p>
 */
public class AdjacentUndirectedUnweighted {
    private HashMap<Integer, List<Integer>> adjacentList;
    private int numberOfNodes;
    /**
     * Creates a new {@code AdjacentUndirectedUnweighted} instance for adjacent undirected unweighted operations.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * Output: initialized object state that is ready for subsequent method calls.
     */
    public AdjacentUndirectedUnweighted() {
        adjacentList = new HashMap<>();
        numberOfNodes = 0;
    }

    /**
     * Executes add node logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param value input value used by the add node process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void addNode(int value) {
        adjacentList.put(value, new ArrayList<>());
        numberOfNodes++;
    }

    /**
     * Executes add edge logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param value1 input value used by the add edge process
     * @param value2 input value used by the add edge process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void addEdge(int value1, int value2) {
        // undirected graph
        adjacentList.get(value1).add(value2);
        adjacentList.get(value2).add(value1);
    }

    /**
     * Executes show connections logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    public void showConnections() {
        Set<Integer> keys = adjacentList.keySet();
        for (int node : keys) {
            List<Integer> nodeConnections = adjacentList.get(node);
            StringBuilder connections = new StringBuilder();
            for (int edge : nodeConnections) {
                connections.append(edge).append(" ");
            }
            System.out.println(node + "-->" + connections);
        }
    }

    /**
     * Executes get number of nodes logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @return computed int result produced by the get number of nodes process
     */
    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    /**
     * Executes main logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * @param args input value used by the main process
     * Output: updates internal state and/or prints computed results to the console.
     */
    public static void main(String[] args) {
        AdjacentUndirectedUnweighted graph = new AdjacentUndirectedUnweighted();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(6, 5);
        graph.showConnections();
        System.out.println("number of nodes = " + graph.getNumberOfNodes());

        // Time complexity proof
//        try {
//            for (int i = 0; i <=1000; i++){
//                System.out.println("i ke " + i);
//                anotherTime();
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    /**
     * Executes another time logic.
     *
     * <p>Summary: documents the key steps used by this practice implementation.</p>
     *
     * Output: updates internal state and/or prints computed results to the console.
     */
    private static void anotherTime() throws Exception{
        for (int j = 0; j <=1000; j++){
            Thread.sleep(1000);
            System.out.println("j ke " + j + " and time " + ZonedDateTime.now());
        }
    }

}
