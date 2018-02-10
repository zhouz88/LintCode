class Trie {
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.map[ch - 'a'] == null) {
                node.map[ch - 'a'] = new TrieNode();
            } 
            node = node.map[ch - 'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.map[ch - 'a'] == null) {
                return false; //wrong1
            }
            node = node.map[ch - 'a'];
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.map[ch - 'a'] == null) {
                return false;
            }
            node = node.map[ch - 'a'];
        }
        return true;
    }
    
    private static class TrieNode {
        TrieNode[] map;
        boolean isWord;
        
        public TrieNode() {
            this.map = new TrieNode[26];
            isWord = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
