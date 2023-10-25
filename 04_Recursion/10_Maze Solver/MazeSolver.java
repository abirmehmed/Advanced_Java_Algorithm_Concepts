    
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
