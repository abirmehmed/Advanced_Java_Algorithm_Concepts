
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
