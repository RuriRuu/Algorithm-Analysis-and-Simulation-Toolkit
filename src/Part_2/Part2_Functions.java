package Part_2;
import java.util.Scanner;
import Part_2.Algorithms.krusksals_algorithm;
import Part_2.Algorithms.prims_algorithm;

import static Part_2.Algorithms.krusksals_algorithm.displayGraph;

public class Part2_Functions {

    //entire kruksals algorithm function
    public static void kruksals(Scanner scan) {
        int V = 0;
        while(true) {
            System.out.print("Enter number of vertices: ");
            try {
                V = scan.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Enter an integer.");
                scan.nextLine();
            }
        }

        int E = 0;
        while (true) {
            System.out.print("Enter number of edges: ");
            try {
                E = scan.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Enter an integer.");
                scan.nextLine();
            }
        }

        int[][] edges = new int[E][3];

        scan.nextLine();

        for (int i = 0; i < E; i++) {
            while (true) {
                System.out.println("Edge " + (i + 1) + " — enter source, destination, weight:");
                try {
                    String line = scan.nextLine().trim();
                    // initially taken as a string
                    String[] parts = line.split("\\s+");
                    // automagically splits input into parts divided by spaces

                    int source = Integer.parseInt(parts[0]);
                    int destination = Integer.parseInt(parts[1]);
                    int weight   = Integer.parseInt(parts[2]);

                    if (source >= V || destination >= V || source < 0 || destination < 0) {
                        System.out.println("Invalid. Nodes must be between 0 and " + (V - 1) + ". Try again.");
                        continue; // filters out impossible nodes
                    }

                    edges[i][0] = source;
                    edges[i][1] = destination;
                    edges[i][2] = weight;
                    break;

                } catch (Exception e) {
                    System.out.println("Invalid input. Enter three integers e.g: 0 1 10");
                }
            }
        }
        displayGraph(V, edges);
        System.out.println("=== Steps Taken ===");
        System.out.println("\nTotal MST cost: " + krusksals_algorithm.KruksalsMST(V, edges));
    }

    // main function for running prims
    public static void prims(Scanner scan){
        int[][] graph = Part2_Functions.PrimsInputHandler.getGraphFromInput(scan);
        prims_algorithm pa = new prims_algorithm();
        System.out.println();
        pa.primMST(graph);

    }

    public class PrimsInputHandler {
        public static int[][] getGraphFromInput(Scanner scan) {
            // Same implementation as getGraphFromInput above
            int V = 0;
            while(true) {
                System.out.print("Enter number of vertices: ");
                try {
                    V = scan.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Enter an integer.");
                    scan.nextLine();
                }
            }

            int E = 0;
            while (true) {
                System.out.print("Enter number of edges: ");
                try {
                    E = scan.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Enter an integer.");
                    scan.nextLine();
                }
            }

            int[][] graph = new int[V][V];
            scan.nextLine();

            for (int i = 0; i < E; i++) {
                while (true) {
                    System.out.println("Edge " + (i + 1) + " — enter source, destination, weight:");
                    try {
                        String line = scan.nextLine().trim();
                        String[] parts = line.split("\\s+");

                        int source = Integer.parseInt(parts[0]);
                        int destination = Integer.parseInt(parts[1]);
                        int weight = Integer.parseInt(parts[2]);

                        if (source >= V || destination >= V || source < 0 || destination < 0) {
                            System.out.println("Invalid. Nodes must be between 0 and " + (V - 1) + ". Try again.");
                            continue;
                        }

                        graph[source][destination] = weight;
                        graph[destination][source] = weight;
                        break;

                    } catch (Exception e) {
                        System.out.println("Invalid input. Enter three integers e.g: 0 1 10");
                    }
                }
            }
            return graph;
        }
    }
}
