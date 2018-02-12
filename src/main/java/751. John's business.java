public class Solution {
    /**
    //
     * @param A: The prices [i]
     * @param k: 
     * @return: The ans array
     */
    public int[] business(int[] A, int k) {
        // Write your code here
        int len = A.length;
        int[] res = new int[len];
        
        TreeSet<Point> set = new TreeSet<>(new Comparator<Point>(){
            public int compare(Point a, Point b) {
                if (a.val == b.val) {
                    return a.id - b.id;
                }
                return Long.compare((long)a.val, (long)b.val);
            }
        });
        
        for (int i = 0; i <= Math.min(k, len-1); i++) {
            set.add(new Point(i, A[i]));
        }
        
        for (int i = 0; i < len; i++) {
            set.remove(new Point(i, A[i]));
            Point tmp = set.iterator().next();
            res[i] = (A[i] >= tmp.val ? A[i] - tmp.val: 0);
            if (i - k >= 0) set.remove(new Point(i - k, A[i - k]));
            if (i + k + 1 < len) set.add(new Point(i + k + 1, A[i + k + 1]));
            set.add(new Point(i, A[i]));
        }
        
        return res;
    }
    
    private class Point {
        int id;
        int val;
        
        Point (int a, int b) {
            id = a;
            val = b;
        }
        
        public boolean equals(Object b) {
            if (b instanceof Point) {
                Point c = (Point)b;
                return this.id == c.id;
            }
            return false;
        }
    }
}
