#
Trie Search: Implement a search operation in a trie data structure, which is used for efficient retrieval of strings based on prefixes.
#

```java
class TrieNode {
    private static final int ALPHABET_SIZE = 26;
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[ALPHABET_SIZE];
        isEndOfWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }

        return current != null && current.isEndOfWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("banana");
        trie.insert("cat");
        trie.insert("dog");

        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("banana")); // true
        System.out.println(trie.search("cat")); // true
        System.out.println(trie.search("dog")); // true
        System.out.println(trie.search("car")); // false
    }
}
```

In this implementation, the `TrieNode` class represents a node in the Trie. Each node contains an array of `children` to store references to its child nodes, and a boolean `isEndOfWord` to indicate whether the node represents the end of a word.

The `Trie` class represents the Trie data structure itself. It has a `root` field to store the root node of the Trie.

The `insert` method is used to insert a word into the Trie. It starts from the root node and iterates through each character of the word. For each character, it checks if the corresponding child node exists. If not, it creates a new node and assigns it as the child of the current node. Finally, it marks the last node as the end of the word by setting the `isEndOfWord` flag to `true`.

The `search` method is used to search for a word in the Trie. It starts from the root node and iterates through each character of the word. For each character, it checks if the corresponding child node exists. If not, it returns `false`. If the word is fully traversed and the last node is marked as the end of a word, it returns `true`.

In the `main` method, an example Trie is created and some words are inserted. Then, the `search` method is called to search for different words in the Trie, and the results are printed.

Please note that this is a simplified implementation of the Trie data structure and does not include other operations like deletion or prefix search. The focus here is on the search operation.
