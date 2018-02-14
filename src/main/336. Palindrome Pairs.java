import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.



*/
class Solution {
    
    private TrieNode root = new TrieNode();

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        insertWords(words);
        searchWords(words, ret);
        return ret;
    }
    
    private void searchWords(String[] words, List<List<Integer>> ret) {
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            String s = words[i];
            int j = 0;
            boolean flag = false;
            for (char ch : s.toCharArray()) { 
                if (node.isWordIdx != -1 && node.isWordIdx != i && isPalindrome(s, j, s.length() - 1)) {
                        ret.add(Arrays.asList(i, node.isWordIdx));
                }
                
                if (node.map[ch - 'a'] == null) {  //worng 1 !!!!!!!!!!!!
                    flag = true;
                    break;
                }
  
                node = node.map[ch - 'a'];
                j++;
            }
            if (flag) continue;
            for (int k : node.abadefList) {
                if (k == i) continue;
                ret.add(Arrays.asList(i, k));
            }
        }
    }
    
    private void insertWords(String[] words) {
        for (int u = 0; u < words.length; u++) {
            TrieNode node = root;
            String s = words[u];
            for (int i = s.length() - 1; i >= 0; i--) {
                char ch = s.charAt(i);
                if (node.map[ch - 'a'] == null) {
                    node.map[ch - 'a'] = new TrieNode();
                }
                if (isPalindrome(s, 0, i)) {  
                    node.abadefList.add(u);
                }
                node = node.map[ch - 'a'];
            }
            node.isWordIdx = u;
            node.abadefList.add(u);
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    
    private static class TrieNode{
        private TrieNode[] map;
        private int isWordIdx;
        private List<Integer> abadefList;

        public TrieNode() {
            this.map = new TrieNode[26];
            this.isWordIdx = -1;
            this.abadefList = new ArrayList<>();
        }
    }
}


