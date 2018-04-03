import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int idx = 0;
        int[] ret = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i>=0;i--) {
            stack.add(i);
        }
        for (int i = nums.length -1; i>=0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ret[i] = -1;
            } else {
                ret[i] = nums[stack.peek()];
            }
            stack.add(i);
        }
        return ret;
    }
}
