import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public List<List<String>> wordSquares(String[] words) {
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        
        for (int i = 0; i < words[0].length(); i++) {
            for (int j = 0; j < words.length; j++) { 
                String tmp = words[j].substring(0, i + 1);
               map.putIfAbsent(tmp, new ArrayList<>());
               map.get(tmp).add(words[j]);
            }
        }
        List<List<String>> res = new ArrayList<>();
        int len = words[0].length();
        dfs(res, words, new ArrayList<>(), len);
        return res;
    }

    private void dfs(List<List<String>> res, String[] words, List<String> list, int len) {
        //base case
        if (list.size() == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        //general
        if (list.size() == 0) {
            for (int i = 0; i < words.length; i++) {
                list.add(words[i]);
                dfs(res, words, list, len);
                list.remove(list.size() - 1);
            }
        } else {
            switch (list.size()) {
                case 1:  
                    if (!map.containsKey(list.get(0).charAt(1)+"")) return;
                    for (String k : map.get(list.get(0).charAt(1)+"")) {
                        list.add(k);
                        dfs(res, words, list, len);
                        list.remove(list.size() - 1);
                    }
                    break;
                case 2:
                    String tmp = list.get(0).charAt(2) + "" + list.get(1).charAt(2);
                    if (!map.containsKey(tmp)) return;
                    for (String k : map.get(tmp)) {
                        list.add(k);
                        dfs(res, words, list, len);
                        list.remove(list.size() - 1);
                    }
                    break;
                case 3:
                    String tmp0 = list.get(0).charAt(3) + "" + list.get(1).charAt(3) + "" + list.get(2).charAt(3);
                    if (!map.containsKey(tmp0)) return;
                    for (String k : map.get(tmp0)) {
                        list.add(k);
                        dfs(res, words, list, len);
                        list.remove(list.size() - 1);
                    }
                    break;
                case 4:
                    String tmp1 = list.get(0).charAt(4) + "" + list.get(1).charAt(4) + "" + list.get(2).charAt(4) + "" + list.get(3).charAt(4);
                    if (!map.containsKey(tmp1)) return;
                    for (String k : map.get(tmp1)) {
                        list.add(k);
                        dfs(res, words, list, len);
                        list.remove(list.size() - 1);
                    }
                    break;
            }
        }
    }
}

//
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        for (String k : words) {
            List<String> list = new ArrayList<>();
            list.add(k);
            dfs(res, root, list);
        }
        return res;
    }

    private void dfs(List<List<String>> res, TrieNode root, List<String> list) {
        if (list.get(0).length() > list.size()) {
            TrieNode node = root;
            for (int i = 0; i < list.size(); i++) {
                node = node.map[list.get(i).charAt(list.size()) - 'a'];
                if (node == null) return;
            }
            List<String> ret = new ArrayList<>();
            getString(node, ret);
            for (int i = 0; i < ret.size(); i++) {
                list.add(ret.get(i));
                dfs(res, root, list);
                list.remove(list.size() - 1);
            }
        } else {
            res.add(new ArrayList<>(list));
        }
    }

    private void getString(TrieNode node, List<String> ret) {
        if (node.word != null) {
            ret.add(node.word);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (node.map[i] != null) {
                getString(node.map[i], ret);
            }
        }
    }

    private void buildTrie(TrieNode root, String[] words) {
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            for (char ch : words[i].toCharArray()) {
                if (node.map[ch - 'a'] == null) {
                    node.map[ch - 'a'] = new TrieNode();
                }
                node = node.map[ch - 'a'];
            }
            node.word = words[i];
        }
    }

    private static class TrieNode {
        TrieNode[] map = new TrieNode[26];
        String word = null;
    }
}
