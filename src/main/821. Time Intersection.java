import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
public class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
*/
public class Solution {
    /**
     * @param seqA: The seqA
     * @param seqB: The seqB
     * @return: The answer
     */
    public Point[] timeIntersection(Point[] seqA, Point[] seqB) {
        // Write your code here
        PriorityQueue<Line> pq = new PriorityQueue<>();
        for (Point k : seqA) {
            pq.add(new Line(k.x, -1));
            pq.add(new Line(k.y, 1));
        }
        for (Point k : seqB) {
            pq.add(new Line(k.x, -1));
            pq.add(new Line(k.y, 1));
        }
        int cnt = 0;

        List<Point> ret = new ArrayList<>();
        int pre = -1;
        while (!pq.isEmpty()) {
            Line node = pq.poll();
            if (node.isstart == -1) {
                cnt++;
                if (cnt == 2) {
                    pre = node.val;
                }
            } else {
                cnt--;
                if (cnt == 1) {
                    ret.add(new Point(pre, node.val));
                }
            }
        }
        Point[] res = new Point[ret.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ret.get(i);
        }
        return res;
    }

    public class Line implements Comparable<Line>{
        int val;
        int isstart;
        public Line(int start, int isstart) {
            this.val = start;
            this.isstart = isstart;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(this.val, o.val) == 0? Integer.compare(o.isstart, isstart)
                    : Integer.compare(this.val, o.val);
        }
    }
}
