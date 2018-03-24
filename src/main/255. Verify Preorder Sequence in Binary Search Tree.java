import java.util.Stack;

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int k : preorder) {
            if (k < min) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < k) {
                min = stack.pop();
            }
            stack.push(k);
        }
        return true;
    }
}
