import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean judgePoint24(int[] nums) {
        double[][][] res = new double[4][4][6];
        Map<Node, Node> map = new HashMap<>();

        map.put(new Node(0, 1), new Node(2, 3));
        map.put(new Node(0, 2), new Node(1, 3));
        map.put(new Node(0, 3), new Node(1, 2));
        map.put(new Node(1, 2), new Node(0, 3));
        map.put(new Node(1, 3), new Node(0, 2));
        map.put(new Node(2, 3), new Node(0, 1));

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                double first = nums[i];
                double second = nums[j];
                res[i][j][0] = first + second;
                res[i][j][1] = first * second;
                res[i][j][2] = first - second;
                res[i][j][3] = - (first - second);
                res[i][j][4] = first / second;
                res[i][j][5] = second / first;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                double[] a = res[i][j];
                Node tmp = map.get(new Node(i, j));
                double[] b = res[tmp.x][tmp.y];
                for (double x : a) {
                    for (double y : b) {
                        if (ok(x, y)) {
                            return true;
                        }
                    }
                }
                for (int k = 0; k < 6; k++) {
                    double[] array = new double[6];
                    array[0] = a[k] + nums[tmp.x];
                    array[1] = a[k] - nums[tmp.x];
                    array[2] = a[k] * nums[tmp.x];
                    array[3] = a[k] / nums[tmp.x];
                    array[4] = -(a[k] - nums[tmp.x]);
                    array[5] = nums[tmp.x] / a[k];
                    for (double t : array) {
                        if (ok(t, nums[tmp.y])) {
                            return true;
                        }
                    }
                }

                for (int k = 0; k < 6; k++) {
                    double[] array = new double[6];
                    array[0] = a[k] + nums[tmp.y];
                    array[1] = a[k] - nums[tmp.y];
                    array[2] = a[k] * nums[tmp.y];
                    array[3] = a[k] / nums[tmp.y];
                    array[4] = -(a[k] - nums[tmp.y]);
                    array[5] = nums[tmp.y] / a[k];
                    for (double t : array) {
                        if (ok(t, nums[tmp.x])) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    private boolean ok(double x, double y) {
        double a = x + y;
        double b = x - y;
        double c = x * y;
        double d = x / y;
        double e = y / x;
        double f = y - x;
        return ok1(a) || ok1(b) || ok1(c) ||ok1(d) ||ok1(e) ||ok1(f) ;
    }

    private boolean ok1(double a) {
        return Math.abs(a - 24.0) <= 1e-3;
    }


    private static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return 10 * x + y;
        }

        public boolean equals(Object o) {
            if ( o instanceof Node) {
                Node t = (Node)o;
                return t.x == x && t.y == y;
            }
            return false;
        }
    }
}
