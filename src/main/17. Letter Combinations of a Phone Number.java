import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//bfs
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        char[][] map = new char[10][];
        map[2] = "abc".toCharArray();
        map[3] = "def".toCharArray();
        map[4] = "ghi".toCharArray();
        map[5] = "jkl".toCharArray();
        map[6] = "mno".toCharArray();
        map[7] = "pqrs".toCharArray();
        map[8] = "tuv".toCharArray();
        map[9] = "wxyz".toCharArray();
        LinkedList<String> q = new LinkedList<>();
        if (digits.length() == 0) return q;
        q.add("");
        int idx = 0;
        while (idx < digits.length()) {
            int size = q.size();
            for (int z = 0; z < size; z++) {
                String node = q.poll();
                for (char ch : map[digits.charAt(idx) - '0']) {
                    q.add(node + ch);
                }
            }
            idx++;
        }
        return q;
    }
}

//dfs
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        char[][] map = new char[10][];
        map[2] = "abc".toCharArray();
        map[3] = "def".toCharArray();
        map[4] = "ghi".toCharArray();
        map[5] = "jkl".toCharArray();
        map[6] = "mno".toCharArray();
        map[7] = "pqrs".toCharArray();
        map[8] = "tuv".toCharArray();
        map[9] = "wxyz".toCharArray();
        char[] t = new char[digits.length()];
        dfs(res, t, digits, map, 0);
        return res;
    }

    private void dfs(List<String> res, char[] t, String digits, char[][] map, int start) {
        if (start == t.length) {
            res.add(new String(t));
            return;
        }
        for (int i = 0; i < map[digits.charAt(start) - '0'].length; i++) {
            t[start] = map[digits.charAt(start) - '0'][i];
            dfs(res, t, digits, map, start + 1);
        }
    }
}
