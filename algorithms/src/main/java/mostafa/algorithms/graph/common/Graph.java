package mostafa.algorithms.graph.common;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Graph {

    public static enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    public static class Edge {
        public int fromIdx;
        public int toIdx;
        public int weight;

        public Edge() {
        }
        public Edge(int fromIdx, int toIdx, int weight) {
            this.fromIdx = fromIdx;
            this.toIdx = toIdx;
            this.weight = weight;
        }
    }

    private int nodesCount = 0;
    int[][] adjMatrix;
    private List<LinkedHashSet<Edge>> adjList;
    private GraphType graphType;

    public Graph(GraphType graphType, int nodesCount) {
        this.graphType = graphType;
        this.nodesCount = nodesCount;
        adjMatrix = new int[nodesCount][nodesCount];
    }

    public Graph(GraphType graphType) {
        this.graphType = graphType;
        adjList = new ArrayList<>();
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public List<LinkedHashSet<Edge>> getAdjList() {
        return adjList;
    }

    public void addEdge(int fromIdx, int toIdx, int weight) {
        if(adjMatrix != null) {
            this.adjMatrix[fromIdx][toIdx] = weight;
            if(graphType.equals(GraphType.UNDIRECTED)) {
                this.adjMatrix[toIdx][fromIdx] = weight;
            }
        } else {
            if(adjList.get(fromIdx) == null) adjList.set(fromIdx, new LinkedHashSet<>());
            adjList.get(fromIdx).add(new Edge(fromIdx, toIdx, weight));

            if(graphType.equals(GraphType.UNDIRECTED)) {
                if(adjList.get(toIdx) == null) adjList.set(toIdx, new LinkedHashSet<>());
                adjList.get(toIdx).add(new Edge(toIdx, fromIdx, weight));
            }
        }


    }

    public GraphType getGraphType() {
        return graphType;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        System.out.println(a.get(0));
    }
}
