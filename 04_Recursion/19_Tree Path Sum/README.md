#
Tree Path Sum: Write a recursive function to find all paths in a binary tree that sum up to a given target value.
#

```java
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class TreePathSum {
    public static List<List<Integer>> findPaths(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathsRecursive(root, targetSum, currentPath, result);
        return result;
    }

    private static void findPathsRecursive(TreeNode currentNode, int targetSum, List<Integer> currentPath,
                                           List<List<Integer>> result) {
        if (currentNode == null) {
            return;
        }

        // Add the current node to the current path
        currentPath.add(currentNode.val);

        // Check if the current node is a leaf node and if its value matches the target sum
        if (currentNode.left == null && currentNode.right == null && currentNode.val == targetSum) {
            // Add the current path to the result
            result.add(new ArrayList<>(currentPath));
        } else {
            // Recursive calls for the left and right subtrees
            findPathsRecursive(currentNode.left, targetSum - currentNode.val, currentPath, result);
            findPathsRecursive(currentNode.right, targetSum - currentNode.val, currentPath, result);
        }

        // Remove the current node from the current path
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        List<List<Integer>> result = findPaths(root, targetSum);

        // Print the result
        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }
}
```

In this implementation, we define a `TreeNode` class to represent the nodes of the binary tree. The `findPaths` method takes a `TreeNode` root and a target sum as parameters and returns a list of lists, where each inner list represents a path from the root to a leaf node that sums up to the target value.

The `findPathsRecursive` method is a helper method that performs the recursive traversal of the tree. It takes the current node, target sum, current path, and the result list as parameters. It checks if the current node is null, and if so, returns. Otherwise, it adds the current node to the current path. If the current node is a leaf node and its value matches the target sum, it adds the current path to the result. Otherwise, it makes recursive calls to the left and right subtrees, subtracting the current node's value from the target sum. After the recursive calls, it removes the current node from the current path to backtrack.

In the `main` method, we create a binary tree and call the `findPaths` method with the root and target sum. We then print the resulting paths.

You can run this code to find all paths in a binary tree that sum up to a given target value.
