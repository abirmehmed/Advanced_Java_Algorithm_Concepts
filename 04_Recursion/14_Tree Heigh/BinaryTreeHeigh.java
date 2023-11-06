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
