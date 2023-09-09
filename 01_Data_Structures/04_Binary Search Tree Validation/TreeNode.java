class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        
        // Create an instance of the Solution class
        Solution solution = new Solution();
        
        // Test the isValidBST method
        boolean isValid = solution.isValidBST(root);
        
        // Print the result
        System.out.println("Is the binary tree a valid binary search tree? " + isValid);
    }
}
