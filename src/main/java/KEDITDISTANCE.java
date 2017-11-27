public class Solution {
    /*
     * @param words: a set of stirngs
     * @param target: a target string
     * @param k: An integer
     * @return: output all the strings that meet the requirements
     */
     
     /*
     623. K Edit Distance 

 Description
 Notes
 Testcase
 Judge
Given a set of strings which just has lower case letters and a target string, output all the strings for each the edit distance with the target no greater than k.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example
Given words = ["abc", "abd", "abcd", "adc"] and target = "ac", k = 1
Return ["abc", "adc"]
     
     
     
     
     */
     
    public List<String> kDistance(String[] words, String target, int k) {
        // write your code here
        this.target = target;
        this.k = k;
        TrieNode root = new TrieNode();
        for (String t : words) {
            insert(t, root);
        }
        int[] dp = new int[target.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        if (root.word != null) {
            res.add("");
        }
        dfs(root, dp, 1);
        return res;
    }
    
    List<String> res = new ArrayList<>();
    String target;
    int k;
    
    void dfs(TrieNode root, int[] pdp, int level) {
        for (char ch : root.map.keySet()) {
            int[] dp = new int[target.length() + 1];
            dp[0] = level;
            for (int j = 1; j < dp.length; j++) {
                if (target.charAt(j - 1) == ch) {
                    dp[j] = pdp[j - 1];
                } else {
                    dp[j] = Math.min(pdp[j - 1] + 1, Math.min(dp[j - 1] + 1, pdp[j] + 1));
                }
            }
            if (root.map.get(ch).word != null && dp[dp.length - 1] <= k) {
                res.add(root.map.get(ch).word);
                dfs(root.map.get(ch), dp, level + 1);
            } else {
                dfs(root.map.get(ch), dp, level + 1);
            } 
        }
    }
    class TrieNode{
        Map<Character, TrieNode> map = new HashMap<>();
        String word = null;
    }
    
    void insert(String word, TrieNode root) {
        TrieNode tmp = root;
        for (char ch : word.toCharArray()) {
            if (!tmp.map.containsKey(ch)) {
                //System.out.println(target.length());
                tmp.map.put(ch, new TrieNode());
            }
            tmp = tmp.map.get(ch);
        }
        tmp.word = word;
    }
}
