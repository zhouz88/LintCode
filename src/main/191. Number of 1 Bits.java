public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n- 1);
            cnt++;
        }
        return cnt;
    }
}

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n - (-n&n); //-k&k求有变数第一个1的值
            cnt++;
        }
        return cnt;
    }
}
