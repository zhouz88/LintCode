import java.util.Arrays;

class Solution {
    public String nearestPalindromic(String n) {
        long a = Long.parseLong(n);
        long small = a - 1;
        long big = a + 1;
        long res1 = getBig(big+"");
        long res2 = getSmall(small+"");
        return  2*a <= res1 + res2 ? res2+"" : res1+"";
    }

    private long getSmall(String big) {
        char[] t = big.toCharArray();
        int m = t.length;
        for (int i = m/2 - 1; i >= 0; i--) {
            if (t[i] == t[m - 1 - i]) {
                continue;
            } else if (t[i] < t[m - 1 - i]) {
                return Long.parseLong(big.substring(0, (m - 1)/2 + 1) +
                        new StringBuilder(big.substring(0, m/2)).reverse().toString());
            } else {
                for (int j = (m - 1)/2; j >= 0; j--) {
                    t[j]--;
                    if (t[j] >= '0') {
                        break;
                    } else {
                        t[j] = '9';
                    }
                }
                if (t[0] == '0') {
                    char[] res = new char[m - 1];
                    Arrays.fill(res, '9');
                    return Long.parseLong(new String(res));
                } else {
                    for (int j = m/2; j < m; j++) {
                        t[j] = t[m - 1 - j];
                    }
                    return Long.parseLong(new String(t));
                }
            }
        }
        
        return Long.parseLong(big);
    }

    private Long getBig(String big) {
        char[] t = big.toCharArray();
        int m = t.length;
        for (int i = m/2 - 1; i >= 0; i--) {
            if (t[i] == t[m - 1 - i]) {
                continue;
            } else if (t[i] > t[m - 1 - i]) {
                 return Long.parseLong(big.substring(0, (m - 1)/2 + 1) +
                         new StringBuilder(big.substring(0, m/2)).reverse().toString());
            } else {
                for (int j = (m - 1)/2; j >= 0; j--) {
                    t[j]++;
                    if (t[j] > '9') {
                        t[j] = '0';
                    } else {
                        break;
                    }
                }
                if (t[0] == '0') {
                    char[] res = new char[m + 1];
                    Arrays.fill(res, '0');
                    t[0] = '1';
                    t[m] = '1';
                    return Long.parseLong(new String(res));
                } else {
                    for (int j = m/2; j < m; j++) {
                        t[j] = t[m - 1 - j];
                    }
                    return Long.parseLong(new String(t));
                }
            }
        }
        return Long.parseLong(big);
    }
}
