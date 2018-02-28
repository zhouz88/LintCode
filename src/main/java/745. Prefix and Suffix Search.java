import java.util.Map;
import java.util.TreeMap;
//treemap
class WordFilter {
    TreeMap<String, Integer> map = new TreeMap<>();
    public WordFilter(String[] words) {
         for (int i = 0; i < words.length; i++) {
             map.put(words[i], i);
         }
    }

    public int f(String prefix, String suffix) {
        int max = -1;
        for (Map.Entry<String, Integer> e : map.subMap(prefix, true, prefix+'\u00ff', true).entrySet()) {
            if (e.getKey().endsWith(suffix)) {
                max = Math.max(max, e.getValue());
            }
        }
        return max;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
 
 //TrieNode
 
 class WordFilter {
    class TrieNode{
        TrieNode[] children;
        int val;
        TrieNode(){
            val = 0;
            children = new TrieNode[26];
            return;
        }
    }
    
    TrieNode root = null;
    public WordFilter(String[] words) {
        root = new TrieNode();
        int idx = 0;
        for(String word : words){
            int low = 0;
            int high = word.length() - 1;
            int len = word.length();
            TrieNode node = root;
            while(low < len){
                char ch1 = word.charAt(low++);
                if(node.children[ch1 - 'a'] == null){
                    node.children[ch1 - 'a'] = new TrieNode();
                }
                node = node.children[ch1 - 'a'];
                node.val = idx;
                
                char ch2 = word.charAt(high--);
                if(node.children[ch2 - 'a'] == null){
                    node.children[ch2 - 'a'] = new TrieNode();
                }
                node = node.children[ch2 - 'a'];
                node.val = idx;
            }
            idx++;
        }
        return;
    }
    
    public int f(String prefix, String suffix) {
        StringBuilder sb = new StringBuilder();
        int len1 = prefix.length();
        int len2 = suffix.length();
        
        int len = Math.max(len1, len2);
        int low = 0;
        int high = len2 - 1;
        int idx = 0;
        while(idx < len){
            sb.append(low < len1 ? prefix.charAt(low) : '*');
            sb.append(high >= 0 ? suffix.charAt(high) : '*');
            low++;
            high--;
            idx++;
        }
        String word = sb.toString();
        return dfs(root, 0, word);
    }
    
    public int dfs(TrieNode node , int idx, String word){
        if(idx == word.length()){
          return node.val;
        }
        char ch = word.charAt(idx);
        if(ch == '*'){
            int res = -1;
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null){
                    res = Math.max(res, dfs(node.children[i], idx + 1, word));
                }
            }
            return res;
        }
        else{
            if(node.children[ch - 'a'] != null){
                return dfs(node.children[ch - 'a'], idx + 1, word);
            }
            else{
                return -1;
            }
        }
    }
}
