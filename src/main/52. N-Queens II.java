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
//
class Solution {
    public int totalNQueens(int n) {
        int[] path = new int[n];
        List<int[]> pathList = new ArrayList<>();
        dfs(path, 0, pathList);
        return pathList.size();
    }

    private void dfs(int[] path, int i, List<int[]> pathList) {
        if (i == path.length) {
            pathList.add(Arrays.copyOf(path, path.length));
            return;
        }
        for (int j = 0; j < path.length; j++) {
            if (isValid(path, i, j)) {
                path[i] =  j;
                dfs(path, i + 1, pathList);
                path[i] = 0;
            }
        }
    }

    private boolean isValid(int[] path, int i, int j) {
        for (int k = 0; k < i; k++) {
            int y = path[k];
            if (y == j || Math.abs(k - i) == Math.abs(y - j)) {
                return false;
            }
        }
        return true;
    }
}
