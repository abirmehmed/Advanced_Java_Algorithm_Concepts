import java.util.*;

class Graph {
    private int V;
    private List<List<Edge>> adjList;

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Edge(v, weight));
        adjList.get(v).add(new Edge(u, weight));
    }

    public List<Integer> shortestPath(int source, int destination) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(node -> node.distance));
        pq.add(new Node(source, 0));
        distance[source] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;

            for (Edge edge : adjList.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    pq.add(new Node(v, distance[v]));
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int current = destination;
        while (current != source) {
            path.add(current);
            int parent = -1;
            int minDistance = Integer.MAX_VALUE;
            for (Edge edge : adjList.get(current)) {
                if (distance[edge.destination] < minDistance) {
                    minDistance = distance[edge.destination];
                    parent = edge.destination;
                }
            }
            current = parent;
        }
        path.add(source);
        Collections.reverse(path);

        return path;
    }

    private static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    private static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int V = 6;
        Graph graph = new Graph(V);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 2);

        int source = 0;
        int destination = 5;

        List<Integer> shortestPath = graph.shortestPath(source, destination);

        System.out.println("Shortest path from node " + source + " to node " + destination + ": " + shortestPath);
    }
}
