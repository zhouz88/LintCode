class Solution {
    public String addStrings(String num1, String num2) {
        char[] t1 = num1.toCharArray();
        char[] t2 = num2.toCharArray();
        int[] res = new int[Math.max(t1.length, t2.length) + 1];
        int idx = res.length - 1, l = t1.length - 1, r = t2.length - 1;
        while (l >= 0 && r >= 0) {
            res[idx--] += t1[l--] - '0' + t2[r--] - '0';
        }
        while (l >= 0) {
            res[idx--] += t1[l--] - '0';
        }
        while (r >= 0) {
            res[idx--] += t2[r--] - '0';
        }
        for (int i = res.length - 1; i >= 1; i--) {
            res[i - 1] += res[i]/10;
            res[i] = res[i] % 10;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < res.length && res[i] == 0) i++;
        if (i == res.length) return "0";
        while (i < res.length) {
            sb.append(res[i++]);
        }
        return sb.toString();
    }
}
