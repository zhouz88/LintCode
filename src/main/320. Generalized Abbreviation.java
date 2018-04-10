import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        int len = word.length();
        int total = 1 << len;
        for (int i = 0; i < total; i++) {
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (int j = 0; j < word.length(); j++) {
                if (((i >> j) & 1) == 1) {
                    if (cnt != 0) {
                        sb.append(cnt);
                    }
                    sb.append(word.charAt(j));
                    cnt = 0;
                } else {
                    cnt++;
                }
            }
            if (cnt != 0) {
                sb.append(cnt);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, word);
        return res;
    }

    private void dfs(List<String> res, String s, int count, int start, String word) {
        if (start == word.length()) {
            if (count != 0) {
                s += count;
            }
            res.add(s);
            return;
        }
        dfs(res, s, count + 1, start + 1, word);
        dfs(res, s + (count == 0 ? "" : count+"") + word.charAt(start), 0,start + 1, word);
    }
}
