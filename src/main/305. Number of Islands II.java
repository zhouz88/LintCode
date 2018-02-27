import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[m * n];
        Arrays.fill(map, -1);
        int cnt = 0;
        final int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        for (int[] node : positions) {
            int tmp = node[0] * n + node[1];
            map[tmp] = tmp;
            cnt++;
            for (int[] dir : directions) {
                int x = dir[0] + node[0];
                int y = dir[1] + node[1];
                if (x>=0&&y>=0&&x<m&&y<n&&map[x*n+y]!=-1) {
                    int fa = find(map, x * n + y);
                    if (fa != tmp) {
                        map[fa] = tmp;
                        cnt--;
                    }
                }
            }
            res.add(cnt);
        }
        return res;
    }

    private int find(int[] map, int start) {
        int parent = start;
        while (parent != map[parent]) {
            parent = map[parent];
        }

        while (start != map[start]) {
            int tmp = start;
            start = map[start];
            map[tmp] = parent;
        }
        return start;
    
   }
}

//recursion

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[m * n];
        Arrays.fill(map, -1);
        int cnt = 0;
        final int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        for (int[] node : positions) {
            int tmp = node[0] * n + node[1];
            map[tmp] = tmp;
            cnt++;
            for (int[] dir : directions) {
                int x = dir[0] + node[0];
                int y = dir[1] + node[1];
                if (x>=0&&y>=0&&x<m&&y<n&&map[x*n+y]!=-1) {
                    int fa = find(map, x * n + y);
                    if (fa != tmp) {
                        map[fa] = tmp;
                        cnt--;
                    }
                }
            }
            res.add(cnt);
        }
        return res;
    }

    private int find(int[] map, int start) {
       if (map[start] == start) {
           return start;
       }
       return map[start] = find(map, map[start]);
    }
}
