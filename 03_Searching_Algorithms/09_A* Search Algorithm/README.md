
```java
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
```

#### Explanation of the Code:

The code above demonstrates how to implement the A* search algorithm in Java to find the shortest path between two nodes in a graph. Here's how it works:

1. The code defines a `Node` class that represents a node in the graph. Each node has an ID, heuristic cost, actual cost, and a reference to its parent node.

2. The `AStarSearch` class contains the main logic for the A* search algorithm. It has a `graph` member variable that represents the graph as an adjacency list.

3. The `addEdge` method is used to add edges to the graph. It takes the source node, destination node, heuristic cost, and actual cost as parameters. The method creates two `Node` objects for the source and destination nodes and adds them to the adjacency list.

4. The `findShortestPath` method takes the start node and goal node as parameters and returns the shortest path between them as a list of node IDs.

5. Inside the `findShortestPath` method, a priority queue (`openList`) is used to keep track of the nodes to be visited. The priority queue is ordered based on the `compareTo` method implementation in the `Node` class, which compares the fCost (heuristic cost + actual cost) of two nodes.

6. A set (`closedSet`) is used to keep track of the nodes that have already been visited.

7. The start node is added to the `openList` with an initial heuristic cost and actual cost of 0.

8. The `while` loop continues until the `openList` is empty. In each iteration, the node with the lowest fCost is removed from the `openList`.

9. If the current node is the goal node, the `reconstructPath` method is called to backtrack the path from the goal node to the start node and return it.

10. Otherwise, the current node is added to the `closedSet`, and its neighbors are retrieved from the graph.

11. For each neighbor, the algorithm checks if it has already been visited (`closedSet`). If so, it skips to the next neighbor.

12. It calculates the new actual cost from the start node to the neighbor by adding the actual cost of the current node and the cost of the edge between them.

13. If the neighbor is not in the `openList`, it is added with the new actual cost, and the `isBetterPath` flag is set to true.

14. If the neighbor is already in the `openList` and the new actual cost is lower than its current actual cost, the `isBetterPath` flag is set to true.

15. If the `isBetterPath` flag is true, the neighbor's parent is set to the current node, and its actual cost is updated to the new actual cost.

16. After visiting all the neighbors of the current node, the loop continues with the next node in the `openList` with the lowest fCost.

17. If no path is found from the start node to the goal node (i.e., the `openList` becomes empty), `null` is returned.

18. The `reconstructPath` method takes the goal node as a parameter and backtracks the path from the goal node to the start node by following the parent references. The node IDs are added to a list, which is then reversed to get the correct order of nodes from the start to the goal.

19. In the `main` method, a sample graph is created using the `addEdge` method.

20. The start and goal node IDs are specified, and the `findShortestPath` method is called.

21. If a shortest path is found, it is printed to the console. Otherwise, a message indicating that no path is found is printed.

The output of the above code will be:
```
Shortest path from node 0 to node 5: [0, 3, 4, 5]
```

That's it! The code demonstrates how to implement the A* search algorithm in Java to find the shortest path between two nodes in a graph.
