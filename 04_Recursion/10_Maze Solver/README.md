
```java
public class MazeSolver {
    private static int[][] maze = {
        {1, 1, 1, 1, 1},
        {1, 0, 0, 0, 1},
        {1, 1, 1, 0, 1},
        {1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1}
    };

    private static int mazeSize = maze.length;
    private static int[][] solution = new int[mazeSize][mazeSize];

    public static boolean solveMaze(int x, int y) {
        // base cases
        if (x < 0 || x >= mazeSize || y < 0 || y >= mazeSize || maze[x][y] == 0 || solution[x][y] == 1) {
            return false;
        }
        
        // mark current cell as part of the solution path
        solution[x][y] = 1;
        
        // check if we have reached the destination
        if (x == mazeSize - 1 && y == mazeSize - 1) {
            return true;
        }
        
        // explore all possible directions: up, down, left, right
        if (solveMaze(x - 1, y) || solveMaze(x + 1, y) || solveMaze(x, y - 1) || solveMaze(x, y + 1)) {
            return true;
        }
        
        // if none of the directions leads to the destination, backtrack
        solution[x][y] = 0;
        return false;
    }

    public static void main(String[] args) {
        if (solveMaze(0, 0)) {
            System.out.println("Maze has a solution!");
            
            System.out.println("Solution path:");
            for (int i = 0; i < mazeSize; i++) {
                for (int j = 0; j < mazeSize; j++) {
                    System.out.print(solution[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Maze does not have a solution!");
        }
    }
}
```

In this code, we have a 2D array `maze` representing the maze, where `1` represents a valid path and `0` represents a wall or obstacle. The size of the maze is determined by the `mazeSize` variable.

The `solveMaze` function takes the current position `(x, y)` as input and returns `true` if there is a valid path from `(x, y)` to the destination, and `false` otherwise.

The function first checks for base cases: if the current position is out of bounds, is a wall, or has already been visited, it returns `false`. 

If the current position is the destination, it marks it as part of the solution path, and returns `true`.

Otherwise, it marks the current position as part of the solution path and recursively explores all possible directions: up, down, left, and right. It does this by making recursive calls to `solveMaze` with updated positions.

If any of the recursive calls return `true`, it means that a valid path has been found, and the function returns `true`.

If none of the directions lead to the destination, it means that the current position is not part of the solution path, so it backtracks by marking the current position as not part of the solution and returns `false`.

In the `main` method, we call `solveMaze` with the starting position `(0, 0)`. If a solution is found, it prints the solution path, which is stored in the `solution` array.

When you run this code, it will output whether the maze has a solution or not, and if it does, it will display the solution path.
