class Solution {
    public String reorganizeString(String S) {
        int[] counts = new int[26];
        int[] valid = new int[26];
        for (char ch : S.toCharArray()) {
            counts[ch - 'a']++;
        }
        char[] res = new char[S.length()];
        for (int i = 0; i < S.length(); i++) {
            int j = next(counts, valid, i, 2);
            if (j == -1) return "";
            res[i] = (char) ('a' + j);
        }
        return new String(res);
    }

    private int next(int[] counts, int[] valid, int index, int k) {
        int maxIdx = -1;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0 && valid[i] <= index) {
                if (maxIdx == -1) maxIdx = i;
                else if (counts[i] > counts[maxIdx]) maxIdx = i;
            }
        }
        if (maxIdx == -1) return -1;
        counts[maxIdx]--;
        if (counts[maxIdx] > 0) {
            valid[maxIdx] = index + k;
        }
        return maxIdx;
    }
}
