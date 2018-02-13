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
