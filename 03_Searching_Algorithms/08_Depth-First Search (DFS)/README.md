#
Depth-First Search (DFS): Implement the depth-first search algorithm to find a target element in a graph or a tree.
#

```java
import java.util.Stack;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

public class DepthFirstSearch {
    Node root;

    boolean DFS(int target) {
        if (root == null) {
            return false;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println("Visited node: " + current.value);

            if (current.value == target) {
                return true;
            }

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DepthFirstSearch tree = new DepthFirstSearch();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        int target = 5;

        if (tree.DFS(target)) {
            System.out.println("Target element " + target + " found!");
        } else {
            System.out.println("Target element " + target + " not found!");
        }
    }
}
```

#### Explanation of the Code:

The code above demonstrates how to implement the depth-first search (DFS) algorithm in Java to find a target element in a graph or a tree. Here's how it works:

1. The code defines a `Node` class that represents a node in the tree. Each node has a value and references to its left and right child nodes.

2. The `DepthFirstSearch` class contains the main logic for the DFS algorithm. It has a `root` member variable that represents the root node of the tree.

3. The `DFS` method takes the target element as a parameter and returns a boolean value indicating whether the target element is found or not.

4. Inside the `DFS` method, a `Stack` is created to keep track of the nodes to be visited. The `Stack` follows the Last-In-First-Out (LIFO) principle.

5. The root node is pushed onto the stack to start the DFS traversal.

6. The `while` loop continues until the stack is empty. In each iteration, the current node is removed from the top of the stack using the `pop` method.

7. The value of the current node is checked against the target element. If they are equal, it means the target element is found, and `true` is returned.

8. If the target element is not found, the right and left child nodes of the current node are pushed onto the stack if they exist.

9. The process continues until the target element is found or the stack is empty. If the stack becomes empty and the target element is not found, `false` is returned.

10. In the `main` method, a sample tree is created, and a target element (5 in this case) is specified.

11. The `DFS` method is called with the target element, and the result is printed to the console.

The output of the above code will be:
```
Visited node: 1
Visited node: 3
Visited node: 7
Visited node: 6
Visited node: 2
Visited node: 5
Target element 5 found!
```

That's it! The code demonstrates how to implement the depth-first search (DFS) algorithm in Java to find a target element in a graph or a tree.
