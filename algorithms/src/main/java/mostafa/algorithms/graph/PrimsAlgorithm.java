package mostafa.algorithms.graph;

import java.util.Arrays;

/**
 * @Author Mostafa
 * On 10/23/22
 * Minimum Spanning Tree Algorithm << This implementation not working with Minus numbers >>
 */
public class PrimsAlgorithm {

    public static void main(String[] args) {

        System.out.println(Math.ceil(5.2));
        System.out.println(Math.round(5.5));

        int[][] G = { { 0, 9, 75, 0, 0 }, { 9, 0, 95, 19, 42 }, { 75, 95, 0, 51, 66 }, { 0, 19, 51, 0, 31 },
                { 0, 42, 66, 31, 0 } };

        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G[i].length; j++) {
                System.out.print(G[i][j] + ", ");
            }
            System.out.println();
        }
       int[][] minSpanningTree = new PrimsAlgorithm().prim(G);
        System.out.println("----------------------------------------");
        for (int i = 0; i < minSpanningTree.length; i++) {
            for (int j = 0; j < minSpanningTree[i].length; j++) {
                System.out.print(minSpanningTree[i][j] + ", ");
            }
            System.out.println();
        }

    }

    public int[][] prim(int[][] g) {
        boolean[] vertexVisited = new boolean[g.length];
        int[][] minSpanningTree = new int[g.length][g.length];
        vertexVisited[0] = true;
        int collectedVertexCount = 1;
        while (collectedVertexCount < g.length) {
            // find min
            int min = Integer.MAX_VALUE;
            int fromExistingVertex = -1;
            int toVertex = -1;

            // loop over all visited
            for (int i = 0; i < g.length; i++) {
                if(vertexVisited[i]) {
                    for (int j = 0; j < g[i].length; j++) {
                        if(vertexVisited[j] == false && g[i][j] > 0 && g[i][j] < min) {
                            min = g[i][j];
                            fromExistingVertex = i;
                            toVertex = j;
                        }
                    }
                }
            }
            vertexVisited[toVertex] = true;
            collectedVertexCount++;
            minSpanningTree[fromExistingVertex][toVertex] = min;
        }
        return minSpanningTree;
    }

}
