public class WordDictionary {
    private TrieNode root;
    class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] child;
        
        public TrieNode() {
            val = ' ';
            isWord = false;
            child = new TrieNode[26];
        }
    }
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode head = root;
        for(int i = 0; i < word.length(); i++) {
            if(head.child[word.charAt(i) - 'a'] == null) {
                head.child[word.charAt(i) - 'a'] = new TrieNode();
            }
            head = head.child[word.charAt(i) - 'a'];
        }
        head.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode head = root;
        return check(word, 0, head);
    }
    
    public boolean check(String word, int index, TrieNode head) {
        if(index == word.length() && head.isWord) return true;
        if(index >= word.length()) return false;
        if(word.charAt(index) != '.') {
            if(head.child[word.charAt(index) - 'a'] != null) {
                return check(word, index + 1, head.child[word.charAt(index) - 'a']);
            }
            else {
                return false;
            }
        }
        else {
            for(int i  = 0 ; i < 26; i++) {
                if(head.child[i] != null) {
                    if(check(word,index+1, head.child[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}