package Part_2.Algorithms;

import java.util.Arrays;

public class prims_algorithm {
    int minKey(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < mstSet.length; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        return min_index;
    }

    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++)
            System.out.println(parent[i] + " - " + i + "\t"
                    + graph[parent[i]][i]);
    }

    public void primMST(int graph[][]) {
        if (graph == null) {
            System.err.println("Error: Graph cannot be null");
            return;
        }

        int V = graph.length;

        if (V == 0) {
            System.err.println("Error: Graph has no vertices");
            return;
        }

        for (int i = 0; i < V; i++) {
            if (graph[i].length != V) {
                System.err.println("Error: Graph matrix is not square at row " + i);
                return;
            }
        }

        int parent[] = new int[V];
        int key[] = new int[V];
        Boolean mstSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        try {
            for (int count = 0; count < V - 1; count++) {
                int u = minKey(key, mstSet);

                if (u == -1) {
                    System.err.println("Error: Graph is disconnected - cannot find minimum key vertex");
                    return;
                }

                mstSet[u] = true;

                for (int v = 0; v < V; v++) {
                    if (graph[u][v] > 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                        parent[v] = u;
                        key[v] = graph[u][v];
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error occurred during MST construction: " + e.getMessage());
            return;
        }

        int connectedCount = 0;
        for (int i = 1; i < V; i++) {
            if (parent[i] != -1) {
                connectedCount++;
            }
        }

        if (connectedCount != V - 1) {
            System.err.println("Warning: Graph is disconnected - MST not possible for all vertices");
            System.err.println("Only " + connectedCount + " out of " + (V - 1) + " edges were added");
        }

        System.out.println("Starting Vertex: " + Arrays.toString(parent));
        printMST(parent, graph);

    }
}