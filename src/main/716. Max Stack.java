import java.util.Stack;

class MaxStack {
    private Stack<Integer> stack = new Stack<>();
    private int max;
    /** initialize your data structure here. */
    public MaxStack() {
        this.max = Integer.MIN_VALUE;
    }

    public void push(int x) {
        if (x >= max) {
            stack.add(max); //store premax to stack
            max = x;
            stack.add(max);
        } else {
            stack.add(x);
        }
    }

    public int pop() {
       int tmp = stack.pop();
       if (tmp == max) {
           max = stack.pop();
       } 
       return tmp;
    }

    public int top() {
       return stack.peek();
    }

    public int peekMax() {
       return max;
    }

    public int popMax() {
        Stack<Integer> next = new Stack<>();
        while (stack.peek() != max) {
            next.add(stack.pop());
        }
        int tmp = stack.pop();
        max = stack.pop();
        while (!next.isEmpty()) {
            int g = next.pop();
            if (g >= max) {
                stack.add(max);
                max = g;
            }
            stack.add(g);
        }
        return tmp;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
