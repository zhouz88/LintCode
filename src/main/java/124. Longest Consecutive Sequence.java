import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
    http://www.lintcode.com/en/problem/longest-consecutive-sequence/
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        //[100, 4, 200, 1, 3, 2],
        if (num == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int k : num) {
            if (!map.containsKey(k)) {
                Integer a = (map.containsKey(k - 1) ? map.get(k - 1) :0);
                Integer b = (map.containsKey(k + 1) ? map.get(k + 1) :0);
                map.put(k, 1 + a + b);
                map.put(k - a, 1 + a + b);
                map.put(k + b, 1 + a + b);
                max = Math.max(max, 1 + a + b);
            } else {
                continue;
            }
        }
        return max;
    }
}
