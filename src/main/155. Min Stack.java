import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        if (x <= min) {
            stack.add(min);
            min = x;
            stack.add(min);
        } else {
            stack.add(x);
        }
    }

    public void pop() {
        int tmp = stack.pop();
        if (tmp == min) {
            min = stack.pop();
        }
    }

    public int top() {
         return stack.peek();
    }

    public int getMin() {
         return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
