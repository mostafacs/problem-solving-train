package mostafa.algorithms.graph;

import mostafa.algorithms.graph.common.Graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {


    public static void main(String[] args) {
        Graph graph = new Graph(Graph.GraphType.DIRECTED, 10);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 5, 22);
        graph.addEdge(1, 2, 21);

        graph.addEdge(6, 9,77);

        traverse(graph, 0);
    }

    public static void traverse(Graph graph, int startNode) {
        handleAdjMatrix(graph, startNode, new HashSet<>());
    }

    private static void handleAdjMatrix(Graph graph, int startNode, Set<Integer> visitedNodes) {
        int[][] adjMatrix = graph.getAdjMatrix();

        Queue<Integer> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(startNode);

        visitedNodes.add(startNode);

        while (!nodeQueue.isEmpty()) {

            int node = nodeQueue.poll();
            System.out.print(node+", ");

            for (int c = 0; c < adjMatrix[node].length; c++) {
                if (adjMatrix[node][c] > 0 && !visitedNodes.contains(c)) {
                        nodeQueue.add(c);
                        visitedNodes.add(c);
                    }
                }
            }

        // important for not connected graph
        if(visitedNodes.size() != adjMatrix.length) {
            for (int i = 0; i < adjMatrix.length; i++) {
                if(!visitedNodes.contains(i)) {
                    handleAdjMatrix(graph, i, visitedNodes);
                }
            }
        }
    }

}
