class Solution {
    public int numIslands(char[][] grid) {
        
        //corner case return 0 or throw Exception() ?? 
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        
        int i, j;
        int cnt = 0;
        for (i = 0; i < m; i++) 
            for (j = 0; j < n; j++) 
                if (grid[i][j] == '1')
                    cnt++;
        
        //make sets;
        int[] map = new int[m*n];
        for (i = 0; i < map.length; i++) {
            map[i] = i;
        }
        
        final int[][] directions = {{1, 0},{-1, 0},{0, -1},{0, 1}};
        
        //union find
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int fa = find(i*n + j, map);
                    
                    for (int[] dir : directions) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;
                        
                        if(x<0||y<0||x>=m||y>=n||grid[x][y] =='0') continue;
                        
                        int tmp = find(n*x+y, map);
                        
                        if (tmp != fa) {
                            map[tmp] = fa;//union wrong1 not map[fa] = tmp;
                            cnt--;
                        }
                    }
                }
                
            }
        }
        
        return cnt;
    }
    
    private int find(int start, int[] map) {
        while (start != map[start]) {
            start = map[start];
        }
        return start;
    }
}
