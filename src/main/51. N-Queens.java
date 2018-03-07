import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] path = new int[n];
        List<int[]> pathList = new ArrayList<>();
        dfs(path, 0, pathList);
        
        StringBuilder[] sb = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            sb[i] = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb[i].append('.');
            }
        }
        for (int[] paths : pathList) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int y = paths[i];
                sb[i].setCharAt(y, 'Q');
                list.add(sb[i].toString());
                sb[i].setCharAt(y, '.');
            }
            res.add(list);
        }
        return res;
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
