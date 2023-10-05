import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

public class BreadthFirstSearch {
    Node root;

    boolean BFS(int target) {
        if (root == null) {
            return false;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Visited node: " + current.value);

            if (current.value == target) {
                return true;
            }

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        BreadthFirstSearch tree = new BreadthFirstSearch();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        int target = 5;

        if (tree.BFS(target)) {
            System.out.println("Target element " + target + " found!");
        } else {
            System.out.println("Target element " + target + " not found!");
        }
    }
}
