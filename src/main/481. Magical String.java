class Solution {
    public int magicalString(int n) {
        String s = "122112";
        int idx = 4;
        if (n == 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        if (n == 4) {
            return 2;
        }
        if (n <= 6) {
            return 3;
        }
        int cnt = 3;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 6; i < 100000;) {
            int pre = sb.charAt(i - 1) - '0';
            int next = (pre == 1 ? 2 : 1);
            int total = sb.charAt(idx++) - '0';
            for (int j = 0; j < total; j++) {
                sb.append(next);
            }
            if (next == 1) {
                cnt += total;
            }
            i += total;
            if (i > n - 1) {
                if (next == 1) {
                    cnt -= (i - (n - 1) - 1);
                    return cnt;
                } else {
                    return cnt;
                }
            }
        }
        return 0;
    }
}
