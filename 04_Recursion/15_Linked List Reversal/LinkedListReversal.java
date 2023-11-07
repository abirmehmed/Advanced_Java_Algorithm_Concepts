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
