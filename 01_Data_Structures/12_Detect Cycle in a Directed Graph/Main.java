public class Main {
    public static void main(String[] args) {
        // Create a graph with 3 vertices
        Graph graph = new Graph(3);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        // Check if the graph contains a cycle
        boolean hasCycle = graph.isCyclic();
        System.out.println("Has cycle: " + hasCycle);
    }
}
