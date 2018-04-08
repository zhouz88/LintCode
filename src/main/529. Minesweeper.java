class Solution {
    public char[][] updateBoard(char[][] board, int[] click) { //only E , M, B , 1
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        } else if (board[x][y] == 'E') {
            update(board, x, y);
            return board;
        } else if (board[x][y] == 'B' || (board[x][y] >= '0' && board[x][y] <= '9')) {
            return board;
        } else {
            return board;
        }
    }

    private void update(char[][] board, int x, int y) {
        int cnt = countOfBombs(board, x, y);
        if (cnt == 0) {
            board[x][y] = 'B';
            for (int[] dir : DIRECTIONS) {
                int a = dir[0] + x;
                int b = dir[1] + y;
                if (a>=0&&b>=0&&a<board.length&&b<board[0].length&&board[a][b]=='E') {
                    update(board, a, b);
                }
            }
        } else {
            board[x][y] = (char)(cnt + '0'); //wrong 1 should not search if is number;
        }
    }

    private static int[][] DIRECTIONS = {{1, 0},{0, 1}, {1, -1}, {-1, 1},{-1, 0},{0, -1},{1, 1},{-1,-1}};

    private int countOfBombs(char[][] board, int x, int y) {
        int cnt = 0;
        for (int[] dir : DIRECTIONS) {
            int a = dir[0] + x;
            int b = dir[1] + y;
            if (a >= 0&&b>=0&&a<board.length&&b<board[0].length&&board[a][b]=='M') {
                cnt++;
            }
        }
        return cnt;
    }
}

//bfs
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        //'E' 'M' 'B' '1'
        switch (board[click[0]][click[1]]) {
            case 'B':
                return board;
            case 'E':
                bfs(board, click);
                return board;
            case 'M':
                board[click[0]][click[1]] = 'X';
                return board;
            default:
                return board;
        }
    }

    private static final int[][] DIRECTIONS = {{1, 0},{-1, 0},{0, 1},{0, -1}, {1, -1},{-1, 1},{1, 1},{-1, -1}};//八个方向bfs;
    
    private void bfs(char[][] board, int[] click) {
        Queue<int[]> q = new LinkedList<>();
        q.add(click);
        int cnt = cnt(board, click[0], click[1]);
        if (cnt > 0) {
            board[click[0]][click[1]] = (char) (cnt + '0');
            return ;
        } else {
            board[click[0]][click[1]] = 'B';
        }
        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int[] dir : DIRECTIONS) {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];
                if (x>=0&&y>=0&&x<board.length&&y<board[0].length&&board[x][y]=='E') {
                    int count = cnt(board, x, y);
                    if (count > 0) {
                        board[x][y] = (char) (count + '0');
                    } else {
                        board[x][y] = 'B';
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
    }

    private int cnt (char[][] grid, int x, int y) {
        int cnt = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (j == i && j == 0) continue;
                int a = x + i;
                int b = y + j;
                if (a>=0&&a<grid.length&&b>=0&&b<grid[0].length&&grid[a][b]=='M'){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
