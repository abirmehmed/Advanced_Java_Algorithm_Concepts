

```java
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTreeHeight {
    public static int calculateHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = calculateHeight(root.left);
            int rightHeight = calculateHeight(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int height = calculateHeight(root);
        System.out.println("Height of the binary tree is: " + height);
    }
}
```

In this code, we define a `Node` class to represent each node of the binary tree. Each node has a data value, as well as left and right child nodes.

The recursive function `calculateHeight` takes the root node of the binary tree as input and returns the height of the tree.

The base case is when the root is `null`, in which case the height is 0.

In the recursive case, we make recursive calls to `calculateHeight` on the left and right subtrees of the root. We then return the maximum height between the left and right subtrees, plus 1 (to account for the current level).

In the `main` method, we create a sample binary tree and call the `calculateHeight` function with the root node. We then print the height of the binary tree.

When you run this code, it will output the height of the binary tree:
```
Height of the binary tree is: 3
```
In this example, the binary tree has a height of 3, which means it has 3 levels.
