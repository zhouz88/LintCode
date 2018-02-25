import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
267. Palindrome Permutation II
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].


*/
class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int cnt = 0;
        int[] map = new int[256];
        for (char ch : s.toCharArray()) {
            map[ch]++;
        }
        Character odd = null;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i< 256; i++) {
            int k = map[i];
            if (k%2 == 1) {
                cnt++;
                map[i]--;
                odd = (char) i;
                for (int j = 0; j < k/2; j++) {
                    list.add((char)i);
                }
            } else if (k > 0 && k%2== 0) {
                for (int j = 0; j < k/2; j++) {
                    list.add((char)i);
                }
            }
        }
        if (cnt > 1) {
            return res;
        }
        boolean[] visited = new boolean[list.size()];
        Collections.sort(list);
        getPerm(res, list, visited, new StringBuilder());
        List<String> ret = new ArrayList<>();
        if (odd == null) {
            for (String k : res) {
                ret.add(k + new StringBuilder(k).reverse().toString());
            }
        } else {
            for (String k : res) {
                ret.add(k + odd + new StringBuilder(k).reverse().toString());
            }
        }
        return ret;
    }

    private void getPerm(List<String> res, List<Character> list, boolean[] visited, StringBuilder sb) {
        if (sb.length() == list.size()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && !visited[i - 1] && list.get(i) == list.get(i - 1)) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                sb.append(list.get(i));
                getPerm(res, list, visited, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
