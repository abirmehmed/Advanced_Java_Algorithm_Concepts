To detect a cycle in a directed graph, you can use the Depth First Search (DFS) algorithm. Here's an example implementation in Java:

```java
import java.util.ArrayList;
import java.util.List;

class Graph {
    private final int numVertices;
    private final List<List<Integer>> adjList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[numVertices];
        boolean[] recursionStack = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (isCyclicUtil(i, visited, recursionStack)) {
                return true;
            }
        }

        return false;
    }

    private boolean isCyclicUtil(int vertex, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[vertex]) {
            return true;
        }

        if (visited[vertex]) {
            return false;
        }

        visited[vertex] = true;
        recursionStack[vertex] = true;

        for (int neighbor : adjList.get(vertex)) {
            if (isCyclicUtil(neighbor, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack[vertex] = false;
        return false;
    }
}
```

The `Graph` class represents a directed graph using an adjacency list. The `addEdge` method is used to add edges between vertices in the graph. The `isCyclic` method uses DFS to check if there is a cycle in the graph.

In the `isCyclic` method, we initialize two boolean arrays: `visited` and `recursionStack`. The `visited` array keeps track of the visited vertices, while the `recursionStack` array is used to detect cycles. We then iterate through each vertex in the graph and call the `isCyclicUtil` method to perform DFS on that vertex.

The `isCyclicUtil` method takes a vertex, `visited`, and `recursionStack` as parameters. If the current vertex is present in the recursion stack, it means we have encountered a back edge and there is a cycle. We return `true` in this case.

If the current vertex is already visited, we return `false` as we have already explored this vertex and its subtree.

Otherwise, we mark the current vertex as visited and add it to the recursion stack. We then recursively check all the neighbors of the current vertex. If any neighbor returns `true` (indicating a cycle), we propagate the result and return `true`.

Finally, before returning from the recursive call, we mark the current vertex as removed from the recursion stack to avoid false detection of cycles in other DFS paths.

Here's an example usage of the `Graph` class:

```java
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
```

Output:
```
Has cycle: true
```

In this example, the graph contains a cycle, so the output is `true`.
