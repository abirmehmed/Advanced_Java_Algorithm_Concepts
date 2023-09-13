To implement a queue using two stacks in Java, we can use one stack for enqueue operations and another stack for dequeue operations. Here's the code:

```java
import java.util.Stack;

class Queue {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public Queue() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void enqueue(int data) {
        enqueueStack.push(data);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        return dequeueStack.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        return dequeueStack.peek();
    }

    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Peek: " + queue.peek()); // Output: 1

        queue.dequeue();
        queue.dequeue();

        System.out.println("Peek: " + queue.peek()); // Output: 3

        queue.dequeue();

        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: true
    }
}
```

Let's go through the code step by step:

1. We start by defining a `Queue` class. It has two private stack fields: `enqueueStack` for enqueue operations and `dequeueStack` for dequeue operations. We use the built-in `Stack` class from the Java Collections framework.

2. In the constructor of the `Queue` class, we initialize both stacks.

3. The `enqueue` method takes an integer `data` as input and adds it to the `enqueueStack` using the `push` method of the `Stack` class.

4. The `dequeue` method removes and returns the front element of the queue. It first checks if the queue is empty by calling the `isEmpty` method. If the `dequeueStack` is empty, it transfers all the elements from the `enqueueStack` to the `dequeueStack` by popping elements from the `enqueueStack` and pushing them to the `dequeueStack`. Then, it calls the `pop` method of the `dequeueStack` to remove and return the front element.

5. The `peek` method returns the value of the front element without removing it. It first checks if the queue is empty by calling the `isEmpty` method. If the `dequeueStack` is empty, it transfers all the elements from the `enqueueStack` to the `dequeueStack` by popping elements from the `enqueueStack` and pushing them to the `dequeueStack`. Then, it calls the `peek` method of the `dequeueStack` to return the front element.

6. The `isEmpty` method checks if both the `enqueueStack` and `dequeueStack` are empty by calling the `isEmpty` method of each stack. If both stacks are empty, it means the queue is empty, and the method returns `true`. Otherwise, it returns `false`.

7. In the `Main` class, we create an instance of the `Queue` class and perform some queue operations to test its functionality. We enqueue elements `1, 2, 3` onto the queue, then we use the `peek` method to print the front element (which is `1`), followed by two `dequeue` operations to remove elements from the queue. Finally, we use the `peek` method again to print the new front element (which is `3`), and we check if the queue is empty using the `isEmpty` method.

The code implements a queue data structure using two stacks. The enqueue operation has a time complexity of O(1) because it only involves pushing a new element onto the enqueue stack. The dequeue and peek operations have an amortized time complexity of O(1), as the elements are moved from the enqueue stack to the dequeue stack only when needed.
