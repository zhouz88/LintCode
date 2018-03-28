class Solution {
    public String rearrangeString(String s, int k) {
        int[] counts = new int[26];
        int[] valid = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }
        char[] res = new char[s.length()];
        for (int i = 0; i < res.length; i++) {
            int j = nextOk(counts, valid, i, k);
            if (j == -1) return "";
            res[i] = (char) (j + 'a');
        }
        return new String(res);
    }

    private int nextOk(int[] counts, int[] valid, int index, int k) {
        int maxIdx = -1;
        for (int i = 0; i < counts.length; i++) {
            if (valid[i] <= index && counts[i] > 0) {
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
