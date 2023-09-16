To serialize and deserialize a binary tree, one common approach is to use a preorder traversal. Here's an example implementation in Java:

```java
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
        } else {
            sb.append(node.val).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = deserializeHelper(queue);
            node.right = deserializeHelper(queue);
            return node;
        }
    }
}
```

The `Codec` class provides two methods: `serialize` and `deserialize`. The `serialize` method takes a `TreeNode` as input and returns a string representation of the binary tree. The `deserialize` method takes a serialized string and returns the corresponding binary tree.

In the `serialize` method, we perform a preorder traversal of the binary tree. We append the value of the current node to the string, followed by a comma. If the node is null, we append the string "null" instead. This process is done recursively for the left and right subtrees.

In the `deserialize` method, we first split the serialized string by commas and store the values in a queue. We then use a recursive helper function, `deserializeHelper`, to reconstruct the binary tree. We dequeue a value from the queue and check if it is "null". If it is, we return null. Otherwise, we create a new `TreeNode` with the parsed integer value and recursively set its left and right children by calling `deserializeHelper` on the queue.

Here's an example usage of the `Codec` class:

```java
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();
        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = codec.deserialize(serialized);
        System.out.println("Deserialized: " + codec.serialize(deserialized));
    }
}
```

Output:
```
Serialized: 1,2,null,null,3,4,null,null,5,null,null,
Deserialized: 1,2,null,null,3,4,null,null,5,null,null,
```

As you can see, the serialized and deserialized trees match, indicating that the serialization and deserialization process is working correctly.
