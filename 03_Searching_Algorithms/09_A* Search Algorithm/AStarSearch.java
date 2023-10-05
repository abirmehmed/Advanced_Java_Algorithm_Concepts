import java.util.*;

class Node implements Comparable<Node> {
    int id;
    int heuristicCost;
    int actualCost;
    Node parent;

    Node(int id, int heuristicCost, int actualCost, Node parent) {
        this.id = id;
        this.heuristicCost = heuristicCost;
        this.actualCost = actualCost;
        this.parent = parent;
    }

    @Override
    public int compareTo(Node other) {
        int fCost = heuristicCost + actualCost;
        int otherFCost = other.heuristicCost + other.actualCost;

        return Integer.compare(fCost, otherFCost);
    }
}

public class AStarSearch {
    private final Map<Integer, List<Node>> graph;

    AStarSearch() {
        this.graph = new HashMap<>();
    }

    public void addEdge(int source, int destination, int heuristicCost, int actualCost) {
        graph.putIfAbsent(source, new ArrayList<>());
        graph.putIfAbsent(destination, new ArrayList<>());

        Node sourceNode = new Node(source, heuristicCost, actualCost, null);
        Node destinationNode = new Node(destination, heuristicCost, actualCost, null);

        graph.get(source).add(destinationNode);
        graph.get(destination).add(sourceNode);
    }

    public List<Integer> findShortestPath(int start, int goal) {
        PriorityQueue<Node> openList = new PriorityQueue<>();
        Set<Node> closedSet = new HashSet<>();

        Node startNode = new Node(start, 0, 0, null);
        openList.add(startNode);

        while (!openList.isEmpty()) {
            Node current = openList.poll();

            if (current.id == goal) {
                return reconstructPath(current);
            }

            closedSet.add(current);

            List<Node> neighbors = graph.get(current.id);
            if (neighbors != null) {
                for (Node neighbor : neighbors) {
                    if (closedSet.contains(neighbor)) {
                        continue;
                    }

                    int newActualCost = current.actualCost + neighbor.actualCost;
                    boolean isBetterPath = false;

                    if (!openList.contains(neighbor)) {
                        openList.add(neighbor);
                        isBetterPath = true;
                    } else if (newActualCost < neighbor.actualCost) {
                        isBetterPath = true;
                    }

                    if (isBetterPath) {
                        neighbor.parent = current;
                        neighbor.actualCost = newActualCost;
                    }
                }
            }
        }

        return null;
    }

    private List<Integer> reconstructPath(Node node) {
        List<Integer> path = new ArrayList<>();
        Node current = node;

        while (current != null) {
            path.add(current.id);
            current = current.parent;
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        AStarSearch graph = new AStarSearch();
        graph.addEdge(0, 1, 6, 5);
        graph.addEdge(0, 3, 2, 3);
        graph.addEdge(1, 2, 2, 2);
        graph.addEdge(1, 4, 1, 2);
        graph.addEdge(2, 5, 3, 1);
        graph.addEdge(3, 4, 1, 3);
        graph.addEdge(4, 5, 1, 1);

        int start = 0;
        int goal = 5;

        List<Integer> shortestPath = graph.findShortestPath(start, goal);

        if (shortestPath != null) {
            System.out.println("Shortest path from node " + start + " to node " + goal + ": " + shortestPath);
        } else {
            System.out.println("No path found from node " + start + " to node " + goal);
        }
    }
}
