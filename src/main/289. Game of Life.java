class Solution {
    public void gameOfLife(int[][] board) {
        //use 1 to 1 5
        //use 0 to 1 4
        //use 0 to 0 3
        //use 1 to 0 2
        String ones = "125";
        String zeros = "034";
        int i, j;
        int cnt = 0;

        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                cntOfones(board, i, j);
            }
        }
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                
                switch (board[i][j]) {
                    case 2:
                        board[i][j] = 0;
                        break;
                    case 3:
                        board[i][j] = 0;
                        break;
                    case 4:
                        board[i][j] = 1;
                        break;
                    case 5:
                        board[i][j] = 1;
                        break;
                }
            }
        }
    }

    private void cntOfones(int[][] board, int a, int b) {
        int cnt = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; //bug wrong 4 times!!!!!........
                int m = a + i;
                int n = b + j;
                if (m<0||n<0||m>=board.length||n>=board[0].length) {
                    continue;
                }
                if (ONES.contains(board[m][n]+"")) {
                    cnt++;
                }
            }
        }
        
        if (ONES.contains(board[a][b]+"") && (cnt == 2 || cnt == 3)) {
            board[a][b] = 5;
        } else if ((ONES.contains(board[a][b]+""))) {
            board[a][b] = 2;
        } else if (ZEROS.contains(board[a][b]+"") &&  cnt == 3) {
            board[a][b] = 4;
        } else if (ZEROS.contains(board[a][b]+"")) {
            board[a][b] = 3;
        }

    }

    private static final String ONES = "125";
    private static final String ZEROS = "034";
    
}
