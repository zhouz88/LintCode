
import java.util.Comparator;
import java.util.List;

class Solution {

    public String findLongestWord(String s, List<String> d) {

        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length()) == 0 ?
                        o1.compareTo(o2) : Integer.compare(o2.length(), o1.length());
            }
        });

        int max = 0;
        for (String K : d) {
            int tmp = getMax(s, K);
           if (tmp != 0) {
               return K;
           }
        }
        return "";
    }

    private int getMax(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                if (j == t.length()) {
                    return j;
                }
            } else {
                i++;
            }
        }
        return 0;
    }
}

//
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        s = " " + s;
        int n = s.length();
        int[] lastId = new int[26];
        int[][] map = new int[n][26];
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            for (int j = lastId[cur - 'a']; j < i; j++) {
                map[j][cur - 'a'] = i;
            }
            lastId[cur - 'a'] = i;
        }
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) { 
                return Integer.compare(o2.length(), o1.length()) == 0 ? 
                        o1.compareTo(o2): Integer.compare(o2.length(), o1.length());
            }
        });
        for (String k : d) {
            int idx = 0;
            for (int i = 0;i < k.length(); i++) {
                idx = map[idx][k.charAt(i) - 'a'];
                if (idx == 0) break;
                if (idx >= map.length) break;
                if (i == k.length() - 1) return k;
            }
        }
        return "";
    }
}
