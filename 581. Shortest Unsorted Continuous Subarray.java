import java.util.Stack;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int l = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] > nums[i]) {
                int tmp = stk.pop();
                l = Math.min(l, tmp);
            }
            stk.add(i);
        }
        stk.clear();
        int r = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
                int tmp = stk.pop();
                r = Math.max(r, tmp);
            }
            stk.add(i);
        }
        if (r <= l) {
            return 0;
        }
        return r - l + 1;
    }
}
