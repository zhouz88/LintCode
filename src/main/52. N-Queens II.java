class Solution {
    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        int[] path = new int[n];
        Arrays.fill(path, -1);
        update(path, n, 0);
        return sum;
    }
    
    private int sum = 0;

    private void update(int[] path, int n, int start) {
        if (start == n) {
            sum++;
            return;
        }
        for (int j = 0; j < n; j++) {
            boolean flag = false;
            for (int i = 0; i < start; i++) {
                if (!ok(path[i], (start)*n+j, n)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                path[start] = start * n + j;
                update(path, n, start + 1);
            }
        }
    }
    
    private boolean ok(int pre, int now, int n) {
        int i = pre/n;
        int j = pre%n;
        int I = now/n;
        int J = now%n;
        if (J == j || Math.abs(I - i) == Math.abs(J - j)) {
            return false;
        }
        return true;
    }
}
