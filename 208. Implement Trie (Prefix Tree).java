class TrieNode {
    
    private char val;
    TrieNode[] children;
    boolean isWord;
    
    public TrieNode() {
        val = ' ';
        children = new TrieNode[26];
        isWord = false;
    }
    // Initialize your data structure here.
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        int length = word.length();
        TrieNode w = root;
        for(int i = 0; i < length; i++) {
            if(w.children[word.charAt(i) - 'a'] == null) {
                w.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            w = w.children[word.charAt(i) - 'a'];
        }
        w.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode head = root;
        for(int i = 0; i < word.length(); i++) {
            if(head.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            head = head.children[word.charAt(i) - 'a'];
        }
        return head.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode head = root;
        for(int i = 0; i < prefix.length(); i++) {
            if(head.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            head = head.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}