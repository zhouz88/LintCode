import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> high = new PriorityQueue<>();
    PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (low.isEmpty()) {
            low.add(num);
            return;
        }

        if (low.size() > high.size()) {
            int tmp = low.peek();
            if (tmp > num) {
                high.add(low.poll());
                low.add(num);
            } else {
                high.add(num);
            }
        } else if (low.size() == high.size()){
            if (high.peek() < num) {
                low.add(high.poll());
                high.add(num);
            } else {
                low.add(num);
            }
        }
    }

    public double findMedian() {
       if (low.size() > high.size()) {
           return low.peek();
       } else {
           return (low.peek() + high.peek())/2.0;
       }
     }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
