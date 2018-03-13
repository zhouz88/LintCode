import java.util.*;

class Solution {
    public boolean isReflected(int[][] ps) {
        if (ps == null || ps.length == 0) {
            return true;
        }

        Arrays.sort(ps, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]) == 0 ? Integer.compare(o1[1], o2[1])
                        :Integer.compare(o1[0], o2[0]) ;
            }
        });

        double midx = 0;
        int m = ps.length;

        if (ps.length % 2 == 0) {
            midx = (ps[m/2 - 1][0] + ps[m/2][0])/2.0;
        } else {
            midx = ps[(m - 1)/2][0];
        }
        final double X = midx;
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < ps.length; i++) {
            if (i > 0 && ps[i][0] == ps[i - 1][0] && ps[i][1] == ps[i - 1][1]) {
                continue;
            } else if (ps[i][0] == midx){
                continue;
            } else {
                list.add(ps[i]);
            }
        }

        int[][] points = new int[list.size()][2];
        m = points.length;
        for (int i = 0; i < list.size(); i++) {
            points[i] = list.get(i);
        }

        PriorityQueue<int[]> left = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Double.compare((o1[0] - X) * (o1[0] - X) + o1[1] * o1[1], (o2[0] - X) * (o2[0] - X) + o2[1] * o2[1]);
            }
        });

        PriorityQueue<int[]> right = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Double.compare((o1[0] - X) * (o1[0] - X) + o1[1] * o1[1], (o2[0] - X) * (o2[0] - X) + o2[1] * o2[1]);
            }
        });

        for (int i = 0; i <= m/2 - 1; i++) {
            left.add(points[i]);
        }
        
        for (int i = (m - 1)/2 + 1; i <= m - 1; i++) {
            right.add(points[i]);
        }
        
        while (!left.isEmpty() && !right.isEmpty()) {
            int[] a = left.poll();
            int[] b = right.poll();
            if (a[0] + b[0] != 2 * midx || a[1] != b[1]) {
                return false;
            }
        }
        return true;
    }
}
