import java.util.*;

public class ZigzagIterator {
    ArrayDeque<Iterator<Integer>> q = new ArrayDeque<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (!v1.isEmpty()) q.addLast(v1.iterator());
        if (!v2.isEmpty())q.addLast(v2.iterator());
    }

    public int next() {
        if (!hasNext()) {
            return -1;
        }
        Iterator<Integer> itr = q.pollFirst();
        int val = itr.next();
        if (itr.hasNext()) q.addLast(itr);
        return val;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
