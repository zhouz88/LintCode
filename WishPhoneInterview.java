import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private int countZeros = 0;

    int checkPairs(List<String> input) {
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        for (String k : input) {
            check(k, start, end);
        }
        int res = 0;
        for (int k : start.keySet()) {
            if (end.containsKey(k)) {
                res += start.get(k) * end.get(k);
            }
        }
        res += countZeros * (countZeros - 1);
        return res;
    }

    private void check(String input, Map<Integer, Integer> start, Map<Integer, Integer> end) {
        int cnt1 = 0;
        boolean canStart = true;
        boolean canEnd = true;
        for (char ch : input.toCharArray()) {
            if (ch == '(') cnt1++;
            else cnt1--;
            if (cnt1 < 0) {
                canStart = false;
            }
        }
        int cnt2 = 0;
        String t = new StringBuilder(input).reverse().toString();
        for (char ch : t.toCharArray()) {
            if (ch == ')') cnt2++;
            else cnt2--;
            if (cnt2 < 0) {
                canEnd = false;
            }
        }
        if (canEnd && canStart) {
            countZeros++;
        } else if (canStart) {
            start.put(cnt1, start.getOrDefault(cnt1, 0) + 1);
        } else if (canEnd) {
            end.put(cnt2, end.getOrDefault(cnt2, 0) + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkPairs(Arrays.asList("()", "()()")));
        System.out.println(new Solution().checkPairs(Arrays.asList("()", "()()", "())", ")", "()())", "(","()(")));
    }
}
