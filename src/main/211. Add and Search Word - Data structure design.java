class WordDictionary {

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.map[ch - 'a'] == null) {
                node.map[ch - 'a'] = new TrieNode();
            }
            node = node.map[ch - 'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, TrieNode root) {
        if (word.equals("")) {
            return root.isWord;
        }

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') { //wrong 1 not ch - 'a'
                boolean flag = false;
                
                for (char tmp = 'a'; tmp <= 'z'; tmp++) {
                    if (node.map[tmp - 'a'] != null) { //wrong 2 tmp not ch !!!!!!!!
                        flag = flag || search(word.substring(i + 1), node.map[tmp - 'a']);
                    }
                }
                
                return flag;
            } else if (node.map[ch - 'a'] == null) {
                return false;
            }
            node = node.map[ch - 'a'];
        }

        return node.isWord;
    }


    private static class TrieNode {
        TrieNode[] map;
        boolean isWord;

        public TrieNode() {
            this.map = new TrieNode[26];
            isWord = false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
