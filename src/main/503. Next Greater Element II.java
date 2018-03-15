import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        int[] ret = new int[nums.length *2];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = nums[i];
            ret[nums.length + i] = nums[i];
        }
        Stack<Integer> stk = new Stack<>();
        for (int i = ret.length - 1; i >= nums.length ; i--) {
            stk.add(i);
        }
        for (int i = nums.length - 1; i >= 0 ; i--) {
            while (!stk.isEmpty() && ret[stk.peek()] <= nums[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                res[i] = -1; 
            } else {
                res[i] = ret[stk.peek()];
            }
            stk.add(i);
        }
        return res;
    }
}
