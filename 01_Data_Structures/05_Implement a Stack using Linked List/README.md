#
Implement a Stack using Linked List: Implement a stack data structure using a linked list. The stack should support push, pop, and peek operations.
#

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class Stack {
    private Node top;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int data = top.data;
        top = top.next;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Peek: " + stack.peek()); // Output: 3

        stack.pop();
        stack.pop();

        System.out.println("Peek: " + stack.peek()); // Output: 1

        stack.pop();

        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true
    }
}
```


1. We start by defining a `Node` class, which represents a node in the linked list. Each node has a `data` field to store the value and a `next` field to reference the next node in the list.

2. Next, we define the `Stack` class. It has a private field `top` that points to the top of the stack (the topmost node in the linked list).

3. The `push` method takes an integer `data` as input and adds a new node with that data to the top of the stack. It does this by creating a new node, setting its `next` field to the current top node, and updating the `top` field to point to the new node.

4. The `pop` method removes and returns the topmost element from the stack. It first checks if the stack is empty by calling the `isEmpty` method. If the stack is not empty, it retrieves the data from the top node, updates the `top` field to point to the next node, and returns the data.

5. The `peek` method returns the value of the topmost element without removing it. It first checks if the stack is empty by calling the `isEmpty` method. If the stack is not empty, it returns the data from the top node.

6. The `isEmpty` method checks if the stack is empty by checking if the `top` field is `null`. If the `top` field is `null`, it means the stack is empty, and the method returns `true`. Otherwise, it returns `false`.

7. In the `Main` class, we create an instance of the `Stack` class and perform some stack operations to test its functionality. We push elements `1, 2, 3` onto the stack, then we use the `peek` method to print the topmost element (which is `3`), followed by two `pop` operations to remove elements from the stack. Finally, we use the `peek` method again to print the new topmost element (which is `1`), and we check if the stack is empty using the `isEmpty` method.

The code implements a stack data structure using a linked list. The push, pop, and peek operations have a time complexity of O(1) because they only involve updating the top reference and accessing or modifying the top node.
