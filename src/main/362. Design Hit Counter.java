import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class HitCounter {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    /** Initialize your data structure here. */
    public HitCounter() {

    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int k = Math.max(0, timestamp - 300);
        int cnt = 0;
        for (Map.Entry<Integer, Integer> e : map.tailMap(k, false).entrySet()) {
            cnt += e.getValue();
        }
        return cnt;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

 import java.util.LinkedList;

class HitCounter {
    LinkedList<Node> q = new LinkedList<>();

    /** Initialize your data structure here. */
    public HitCounter() {

    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (!q.isEmpty() && q.peekLast().val == timestamp) {
            q.peekLast().count ++;
        } else {
            q.addLast(new Node(timestamp, 1));
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!q.isEmpty() && q.peekFirst().val <= timestamp - 300) {
            q.pollFirst();
        }
        int sum = 0, size = q.size();
        for (int i = 0; i < size; i++) {
            Node node = q.pollFirst();
            sum += node.count;
            q.addLast(node);
        }
        return sum;
    }
    
    private static class Node {
        int val;
        int count;
        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
