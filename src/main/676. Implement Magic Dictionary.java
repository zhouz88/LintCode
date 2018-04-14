class MagicDictionary {
    private TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.root = new TrieNode();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String k : dict) {
            TrieNode node = root;
            for (char ch : k.toCharArray()) {
                if (node.f[ch - 'a'] == null) {
                    node.f[ch - 'a'] = new TrieNode();
                }
                node = node.f[ch - 'a'];
            }
            node.word = k;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return dfs(word, 0, 0, root);
    }

    private boolean dfs(String word, int start, int cnt, TrieNode node) {
        if (start == word.length()) {
            return node.word != null && cnt == 1;
        }
        boolean res = false;
        if (cnt == 0) {
            for (int i = 0; i < 26; i++) {
                if (node.f[i] != null){
                    if (i != word.charAt(start) - 'a') {
                        res |= dfs(word, start + 1, 1, node.f[i]);
                    } else {
                        res |= dfs(word, start + 1, 0, node.f[i]);
                    }
                }
            }
        } else {
            if (node.f[word.charAt(start) - 'a'] != null) {
                res |= dfs(word, start + 1, 1, node.f[word.charAt(start) - 'a']);
            }
        }
        return res;
    }

    private static class TrieNode {
        TrieNode[] f = new TrieNode[26];
        String word = null;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
