package Part_2.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class krurksals_algorithm {

    public static int KruksalsMST(int vertices, int[][] edges){
        // weighted sorting
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2])); // e represents 1 edge
        dataSet dataSet = new dataSet(vertices);
        int cost = 0, count = 0;

        // actual sorting in action
        for(int[] e: edges){
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
        return cost;
    }

    // i just took this from gfg
    static class dataSet {
        private int[] parent, rank;

        public dataSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y) {
            int s1 = find(x);
            int s2 = find(y);
            if (s1 != s2) {
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
    // build adjacency list
    ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
    for (int i = 0; i < vertices; i++) {
        adjList.add(new ArrayList<>());
    }

    for (int[] e : edges) {
        int src = e[0], dst = e[1], w = e[2];
        adjList.get(src).add(new int[]{dst, w});
        adjList.get(dst).add(new int[]{src, w});
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
