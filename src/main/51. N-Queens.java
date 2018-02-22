import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<int[]> ret = new ArrayList<>();
        if (n == 0) {
            return new ArrayList<>();
        }
        int[] path = new int[n];
        Arrays.fill(path, -1);
        update(path, n, 0, ret);
        
        char[][] sb = new char[n][n];
        for (char[] ch : sb) {
            Arrays.fill(ch, '.');
        }
        List<List<String>> res = new ArrayList<>();
        for (int[] k : ret) {
            List<String> list = new ArrayList<>();
            for (int u : k) {
                int i  = u/n;
                int j = u%n;
                sb[i][j] = 'Q';
                list.add(new String(sb[i]));
                sb[i][j] = '.';
            }
            res.add(list);
        }
        return res;
    }

    private void update(int[] path, int n, int start, List<int[]> ret) {
        if (start == n) {
            ret.add(Arrays.copyOf(path, n));
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
                update(path, n, start + 1, ret);
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
