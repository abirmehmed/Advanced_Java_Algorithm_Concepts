#
LRU Cache: Implement an LRU (Least Recently Used) cache, which is a data structure that stores a fixed number of items and evicts the least recently used item when the cache reaches its capacity. The cache should support get and put operations.
#

Sure! Here's an example implementation of an LRU Cache in Java:

```java
import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
        } else {
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}
```

This implementation uses a combination of a HashMap and a doubly linked list to keep track of the cache entries and their order of usage. The HashMap allows for efficient lookup of cache entries, while the doubly linked list allows for efficient removal and insertion of entries.

The `get` method retrieves the value associated with a given key from the cache. If the key exists in the cache, the corresponding node is moved to the front of the list to indicate its most recent usage. If the key does not exist in the cache, the method returns -1.

The `put` method adds or updates a cache entry with the given key and value. If the key already exists in the cache, the corresponding node is updated and moved to the front of the list. If the cache has reached its capacity, the least recently used entry (at the end of the list) is evicted before adding the new entry.

Note that this implementation assumes that both the key and value are integers. If you want to use other types, you can modify the `Node` class and the method signatures accordingly.
