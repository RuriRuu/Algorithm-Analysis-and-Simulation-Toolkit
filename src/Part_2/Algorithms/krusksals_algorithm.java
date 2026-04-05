package Part_2.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class krusksals_algorithm {

    public static int KrusksalsMST(int vertices, int[][] edges){
        if (vertices <= 0) {
            System.err.println("Error: Invalid number of vertices");
            return -1;
        }

        if (edges == null || edges.length == 0) {
            System.err.println("Error: No edges provided");
            return -1;
        }

        int[][] validEdges = new int[edges.length][3];
        int validCount = 0;
        for (int[] e : edges) {
            if (e.length == 3 && e[0] >= 0 && e[0] < vertices && e[1] >= 0 && e[1] < vertices && e[2] > 0) {
                validEdges[validCount++] = e;
            } else {
                System.err.println("Skipped invalid edge: " + Arrays.toString(e));
            }
        }

        if (validCount == 0) {
            System.err.println("Error: No valid edges found");
            return -1;
        }

        int[][] filteredEdges = new int[validCount][3];
        for (int i = 0; i < validCount; i++) {
            filteredEdges[i] = validEdges[i];
        }

        // weighted sorting
        Arrays.sort(filteredEdges, Comparator.comparingInt(e -> e[2])); // e represents 1 edge
        dataSet dataSet = new dataSet(vertices);
        int cost = 0, count = 0;

        // actual sorting in action
        for(int[] e: filteredEdges){
            int x = e[0], y = e[1], w = e[2];

            if (dataSet.find(x) != dataSet.find(y)) {
                dataSet.union(x, y);
                cost += w;
                System.out.println("Added edge: " + x + " → " + y + " (weight " + w + ") | Total cost so far: " + cost);
                if (++count == vertices - 1) break;
            }else{
                System.out.println("Skipped edge: " + x + " → " + y + " (weight " + w + ") | Would create a cycle");
            }
        }

        if (count != vertices - 1) {
            System.err.println("Warning: Graph is disconnected - MST not possible for all vertices");
            return -1;
        }

        return cost;
    }

    // i just took this from gfg
    static class dataSet {
        private int[] parent, rank;

        public dataSet(int n) {
            if (n <= 0) {
                parent = new int[0];
                rank = new int[0];
                return;
            }
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int i) {
            if (i < 0 || i >= parent.length) return -1;
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y) {
            if (x < 0 || y < 0 || x >= parent.length || y >= parent.length) return;
            int s1 = find(x);
            int s2 = find(y);
            if (s1 != s2 && s1 != -1 && s2 != -1) {
                if (rank[s1] < rank[s2]) {
                    parent[s1] = s2;
                } else if (rank[s1] > rank[s2]) {
                    parent[s2] = s1;
                } else {
                    parent[s2] = s1;
                    rank[s1]++;
                }
            }
        }
    }

    public static void displayGraph(int vertices, int[][] edges) {
        if (vertices <= 0 || edges == null) {
            System.err.println("Error: Cannot display invalid graph");
            return;
        }

        // build adjacency list
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            if (e.length == 3) {
                int src = e[0], dst = e[1], w = e[2];
                if (src >= 0 && src < vertices && dst >= 0 && dst < vertices && w > 0) {
                    adjList.get(src).add(new int[]{dst, w});
                    adjList.get(dst).add(new int[]{src, w});
                } else {
                    System.err.println("Skipped invalid edge in display: " + Arrays.toString(e));
                }
            } else {
                System.err.println("Skipped malformed edge in display: " + Arrays.toString(e));
            }
        }

        // display
        System.out.println("\n=== Graph Structure ===");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Node " + i + " → ");
            if (adjList.get(i).isEmpty()) {
                System.out.print("no connections");
            } else {
                for (int[] neighbor : adjList.get(i)) {
                    System.out.print("[Node " + neighbor[0] + ", weight " + neighbor[1] + "] ");
                }
            }
            System.out.println();
        }
        System.out.println("========================\n");
    }
}