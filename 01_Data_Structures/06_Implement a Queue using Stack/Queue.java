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
