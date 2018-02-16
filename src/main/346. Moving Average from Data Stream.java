import java.util.ArrayDeque;

class MovingAverage {
    private ArrayDeque<Integer> deque = new ArrayDeque<>();
    private double sum = 0;
    private int size;
    private int i;
    /** Initialize your data structure here. */
    
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        sum += val;
        deque.add(val);
        double ret = 0.0;
        
        if (i - size + 1 >= 0) {
            ret = sum/size;
            sum -= deque.pollFirst();
        } else {
            ret = sum/(i + 1); //wrong 1
        }
        
        i++;
        return ret;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
