

import java.util.Arrays;

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int n = S.length();
        int[] lastIdx = new int[26];
        int[][] nexts = new int[n][26];
        for (int[] k : nexts) {
            Arrays.fill(k, -1);
        }
        Arrays.fill(lastIdx, -1);
        for (int i = 0; i < S.length(); i++) {
            for (int j = lastIdx[S.charAt(i) - 'a'] + 1; j <= i; j++) {
                nexts[j][S.charAt(i) - 'a'] = i;
            }
            lastIdx[S.charAt(i) - 'a'] = i;
        }
        int cnt = 0;
        for (String k : words) {
            cnt += get(nexts, k);
        }
        return cnt;
    }

    private int get(int[][] nexts, String k) {
        int idx = 0;
        for (int i = 0; i < k.length(); i++) {
            if (idx == nexts.length) return 0;
            idx = nexts[idx][k.charAt(i) - 'a'];
            if (idx == -1) return 0;
            idx += 1;
        }
        return 1;
    }
}
