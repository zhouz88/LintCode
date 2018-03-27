public class Solution {
    public String fractionToDecimal(int n, int e) {
        int sign = getSign(n, e);
        long D = Math.abs((long) n);
        long d = Math.abs((long) e);
        StringBuilder sb = new StringBuilder();
        long res = D/d;
        long m  = D%d;
        if (m == 0) {
            sb.append(sign*res);
            return sb.toString();
        }
        sb.append(res);
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        m *= 10;
        while (m > 0) {
            long ret = m/d;
            if (map.containsKey(m)) {
                int idx = map.get(m);
                sb.insert(idx, "(");
                sb.append(")");
                break;
            }
            map.put(m, sb.length());
            sb.append(ret);
            m = 10 * (m%d);
        }
        return sign == -1 ? "-" + sb.toString() : sb.toString();
    }

    private int getSign(int n, int d) {
        int cnt = 0;
        if (n < 0) {
            cnt++;
        }
        if (d < 0) {
            cnt++;
        }
        return cnt == 1 ? -1 : 1;
    }
}
