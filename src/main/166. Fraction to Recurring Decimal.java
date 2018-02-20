import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int n, int d) {
        if (n == 0) {
            return "0";
        }
        int sign = getSign(n, d);
        long numerator = Math.abs((long) n);
        long denominator = Math.abs((long) d);
        StringBuilder sb = new StringBuilder();

        sb.append(numerator/denominator);
        long m = numerator%denominator;
        if (m != 0) {
            sb.append(".");
        } else {
            if (sign == -1) {
                return "-"+sb.toString();

            }
            return sb.toString();
        }
        Map<Long, Integer> map = new HashMap<>();//number - index
        int idx = sb.length();
        while (true) {
            m *= 10;
            if (map.containsKey(m)) {
                int i = map.get(m);
                sb.insert(i, "(");
                sb.append(")");
                break;
            } else {
                map.put(m, idx++);
            }
            sb.append(m/denominator);
            m = m%denominator;
            if (m == 0) {
                break;
            }
        }
        if (sign == -1) {
            return "-"+sb.toString();
        }
        return sb.toString();
    }

    private int getSign(int a, int b) {
        int cnt = 0;
        if (a < 0) {
            cnt++;
        }
        if (b < 0 ) {
            cnt++;
        }
        return cnt == 1 ? -1 : 1;
    }
}
