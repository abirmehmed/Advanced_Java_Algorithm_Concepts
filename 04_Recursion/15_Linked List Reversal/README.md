#
Linked List Reversal: Write a recursive function to reverse a linked list. 
#

```java
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}

public class LinkedListReversal {
    public static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node reversed = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;

        return reversed;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original linked list:");
        printLinkedList(head);

        Node reversed = reverseLinkedList(head);

        System.out.println("Reversed linked list:");
        printLinkedList(reversed);
    }

    public static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
```

In this code, we define a `Node` class to represent each node of the linked list. Each node has a data value, as well as a reference to the next node.

The recursive function `reverseLinkedList` takes the head of the linked list as input and returns the head of the reversed linked list.

The base case is when the head is `null` or the head's next node is `null`. In this case, we simply return the head itself.

In the recursive case, we make a recursive call to `reverseLinkedList` on the next node of the head. This will reverse the sublist starting from the next node.

Once we have the reversed sublist, we update the next pointer of the next node to point back to the current head. This effectively reverses the direction of the pointers.

Finally, we set the next pointer of the current head to `null`, as it will become the last node of the reversed list.

In the `main` method, we create a sample linked list and call the `reverseLinkedList` function with the head node. We then print the original and reversed linked lists using the `printLinkedList` method.

When you run this code, it will output the original and reversed linked lists:
```
Original linked list:
1 2 3 4 
Reversed linked list:
4 3 2 1
```

In this example, the original linked list is `1 -> 2 -> 3 -> 4`, and the reversed linked list is `4 -> 3 -> 2 -> 1`.
