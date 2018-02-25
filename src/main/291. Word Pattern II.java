import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {

    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null) {
            return true;
        }
        if (pattern.length() == 0 && str.length() == 0) {
            return true;
        }
        if (pattern.length() == 0) {
            return false;
        }
        return dfs(pattern, str, 0, 0, new HashMap<>(), new HashSet<String>());
    }

    private boolean dfs(String p, String s, int start1, int start2, Map<Character, String> map, HashSet<String> values) {
        if (start1 == p.length() && start2 == s.length()) {
            return true;
        }
        if (start1 == p.length() || start2 == s.length()) {
            return false;
        }

        int i;

        char cur = p.charAt(start1);

        boolean flag = false;

        for (i = start2; i < s.length(); i++) {
            String tmp = s.substring(start2, i + 1);
            if (map.containsKey(cur)) {
                if (map.get(cur).equals(tmp)) {
                    flag |= dfs(p, s, start1 + 1, i + 1, map, values);
                    if (flag) break;
                } else {
                    continue;
                }
            } else if (values.contains(tmp)){
                continue;
            } else {
                map.put(cur, tmp);
                values.add(tmp);
                flag |= dfs(p, s, start1 + 1, i + 1, map, values);
                if (flag) break;
                map.remove(cur);
                values.remove(tmp);
            }
        }

        return flag;
    }
}

/*
291. Word Pattern II
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
Notes:
You may assume both pattern and str contains only lowercase letters.



*/
