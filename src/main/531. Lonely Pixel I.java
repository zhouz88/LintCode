import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findLonelyPixel(char[][] picture) {
        int[] rows = new int[picture.length];
        int[] cols = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && rows[i] == 1 && cols[j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
