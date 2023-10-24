
```java
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("In-order traversal: ");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        System.out.print("Pre-order traversal: ");
        tree.preOrderTraversal(tree.root);
        System.out.println();

        System.out.print("Post-order traversal: ");
        tree.postOrderTraversal(tree.root);
        System.out.println();
    }
}
```

In this code, we define a `Node` class to represent each node in the binary tree. Each `Node` object has a data value and left/right pointers to its left and right child nodes. 

The `BinaryTree` class provides methods to perform in-order, pre-order, and post-order traversals. 

The `inOrderTraversal` method performs an in-order traversal of the binary tree. It takes a `Node` object as input and recursively traverses the left subtree, visits the current node, and then recursively traverses the right subtree.

The `preOrderTraversal` method performs a pre-order traversal of the binary tree. It takes a `Node` object as input and first visits the current node, then recursively traverses the left subtree, and finally recursively traverses the right subtree.

The `postOrderTraversal` method performs a post-order traversal of the binary tree. It takes a `Node` object as input and first recursively traverses the left subtree, then recursively traverses the right subtree, and finally visits the current node.

In the `main` method, we create a binary tree and initialize it with sample data. We then call the traversal methods to print the elements of the tree in the respective traversal orders.

When you run this code, it will output the in-order, pre-order, and post-order traversals of the binary tree.
