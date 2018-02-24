import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> q;
    Queue<Integer> another;

    /** Initialize your data structure here. */
    public MyStack() {
        this.q = new LinkedList<>();
        this.another = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q.size() != 1) {
            another.add(q.poll());
        }
        int res = q.poll();
        while (!another.isEmpty()) {
            q.add(another.poll());
        }
        return res;
    }

    /** Get the top element. */
    public int top() {
        Queue<Integer> another = new LinkedList<>();
        while (q.size() != 1) {
            another.add(q.poll());
        }
        int res = q.poll();
        while (!another.isEmpty()) {
            q.add(another.poll());
        }
        q.add(res);
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
