import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        //edge case
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        
        stack.add(-1);
        int max = -1;
        
        for (int i = 0; i < heights.length;  i++) {//small value determines the next result, Big one life cycle ends
            while (stack.peek() != - 1 && heights[stack.peek()] > heights[i]) {
                int h = stack.pop() ;
                max = Math.max(max, (i - 1 - stack.peek())*heights[h]);
            }
            stack.add(i);
        }
        
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() -1));
        }
        
        return max;
    }
}
