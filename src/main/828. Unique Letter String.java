import java.util.ArrayList;
import java.util.List;

class Solution {
    public int uniqueLetterString(String S) {
        List<Integer>[] map = new ArrayList[26];
        int len = S.length();
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < S.length(); i++) {
            int temp = S.charAt(i) - 'A';
            map[temp].add(i);
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            List<Integer> list = map[i];
            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    int start = list.get(0) - 0 + 1;
                    int end = j + 1 <= list.size() - 1 ? list.get(j + 1) - list.get(j) : len - list.get(0);
                    cnt += start * end;
                } else if (j == list.size() - 1) {
                    int start = list.get(j) - list.get(j - 1);
                    int end = len  - list.get(j);
                    cnt += start * end;
                } else {
                    int start = list.get(j) - list.get(j - 1);
                    int end = list.get(j + 1) - list.get(j);
                    cnt += start * end;
                }
            }
        }
        return cnt;
    }
}

// 0, 1// 
