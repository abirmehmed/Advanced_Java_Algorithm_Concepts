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
