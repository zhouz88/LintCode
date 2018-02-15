import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String k : wordDict) {
            insert(k, root);
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && contains(s.substring(j, i), root)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        Map<Integer, List<String>> map = new HashMap<>();

        List<String> ret = new ArrayList<>();
        return update(root, dp, s, 0, map);
       
    }

    private List<String> update(TrieNode root, boolean[] dp, String s, int start,  Map<Integer, List<String>> map) {
        if (map.containsKey(start)) {
            return map.get(start);
        }

        List<String> ret = new ArrayList<>();
        
        if (start == s.length()) {
            ret.add("");
            return ret;
        }
        
        for (int i = start + 1; i <= s.length(); i++) {
            if (dp[i]) {
                String k = s.substring(start, i);

                if (!contains(k, root)) {
                    continue;
                }
                
                List<String> tmp = update(root, dp, s, i, map);
                
                if (tmp.size() == 0) {
                    continue;
                }
                
                for (String t : tmp) {
                    if ("".equals(t)) {
                        ret.add(k);//bug 1
                    } else {
                        ret.add(k + " " + t);//bug 1
                    }
                 
                }
            }
        }
        
        map.put(start, ret);
        return ret;
    }

    private void insert(String k, TrieNode root) {
        TrieNode node = root;
        for (char ch : k.toCharArray()) {
            if (node.map[ch - 'a'] == null) {
                node.map[ch - 'a'] = new TrieNode();
            }
            node = node.map[ch - 'a'];
        }
        node.isWord = true;
    }

    private boolean contains(String k, TrieNode root) {
        TrieNode node = root;
        for (char ch : k.toCharArray()) {
            if (node.map[ch - 'a'] == null) {
                return false;
            }
            node = node.map[ch - 'a'];
        }
        return node.isWord;
    }

    private static class TrieNode{
        TrieNode[] map = new TrieNode[26];
        boolean isWord = false;
    }
}
