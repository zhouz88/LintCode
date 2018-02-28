class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if (N == 0)
            return 0;
        
        int[][] M = new int[N][N];
        for (int i = 0; i < N; i ++) 
            Arrays.fill(M[i], 1);
        
        for (int[] tmp : mines) 
            M[tmp[0]][tmp[1]] = 0;
        
        int[][] Up = getOnesUp(M, N);
        int[][] Down = getOnesDown(M, N);
        int[][] Left = getOnesLeft(M, N);
        int[][] Right = getOnesRight(M, N);
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int min = Math.min(Math.min(Up[i][j], Down[i][j]), Math.min(Left[i][j], Right[i][j]));
                if (min > max) max = min;
            }
        }
        return max;
    }
    
    public int[][] getOnesUp(int[][] M, int N) {
        int[][] Up = new int[N][N];
        for (int j = 0; j < N; j++) {
            Up[0][j] = M[0][j] == 1 ? 1 : 0;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Up[i][j] = (M[i][j] == 0 ? 0 : Up[i - 1][j] + 1);
            }
        }
        return Up;
    }
    
    public int[][] getOnesDown(int[][] M, int N) {
        int[][] Down = new int[N][N];
        for (int j = 0; j < N; j++) {
            Down[N - 1][j] = M[N - 1][j] == 1 ? 1 : 0;
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                Down[i][j] = (M[i][j] == 0 ? 0 : Down[i + 1][j] + 1);
            }
        }
        return Down;
    }
    
    public int[][] getOnesLeft(int[][] M, int N) {
        int[][] Left = new int[N][N];
        for (int i = 0; i < N; i++) {
            Left[i][0] = M[i][0] == 1 ? 1 : 0;
        }
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < N; i++) {
                Left[i][j] = (M[i][j] == 0 ? 0 : Left[i][j - 1] + 1);
            }
        }
        return Left;
    }
    
   public int[][] getOnesRight(int[][] M, int N) {
        int[][] Right = new int[N][N];
        for (int i = 0; i < N; i++) {
            Right[i][N - 1] = M[i][N - 1] == 1 ? 1 : 0;
        }
        for (int j = N - 2; j >= 0; j--) {
            for (int i = 0; i < N; i++) {
                Right[i][j] = (M[i][j] == 0 ? 0 : Right[i][j + 1] + 1);
            }
        }
        return Right;
    }
}
Report Cheating 
