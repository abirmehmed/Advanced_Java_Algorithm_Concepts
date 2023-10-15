class Node {
    int data;
    Node left, right;
    boolean isRed;

    public Node(int data) {
        this.data = data;
        this.isRed = true;
    }
}

public class RedBlackTree {
    private Node root;

    public boolean search(int key) {
        Node current = root;

        while (current != null) {
            if (key == current.data) {
                return true;
            } else if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    // Other methods for insertion, deletion, and balancing the tree
    // ...

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(7);
        tree.root.right.left = new Node(12);
        tree.root.right.right = new Node(18);

        int key = 7;
        boolean found = tree.search(key);

        if (found) {
            System.out.println("Element " + key + " found in the Red-Black Tree.");
        } else {
            System.out.println("Element " + key + " not found in the Red-Black Tree.");
        }
    }
}
