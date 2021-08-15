package zero.to.mastery.data_structures.graph;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class AdjacentUndirectedUnweighted {
    private HashMap<Integer, List<Integer>> adjacentList;
    private int numberOfNodes;
    public AdjacentUndirectedUnweighted() {
        adjacentList = new HashMap<>();
        numberOfNodes = 0;
    }

    public void addNode(int value) {
        adjacentList.put(value, new ArrayList<>());
        numberOfNodes++;
    }

    public void addEdge(int value1, int value2) {
        // undirected graph
        adjacentList.get(value1).add(value2);
        adjacentList.get(value2).add(value1);
    }

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

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

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

    private static void anotherTime() throws Exception{
        for (int j = 0; j <=1000; j++){
            Thread.sleep(1000);
            System.out.println("j ke " + j + " and time " + ZonedDateTime.now());
        }
    }
}
