import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minTotalDistance(int[][] grid) {
       List<Integer> up = new ArrayList<>();
       List<Integer> horizontal = new ArrayList<>();

       int i , j;
       for (i = 0; i < grid.length; i++) {
           for (j = 0; j < grid[0].length; j++) {
               if (grid[i][j] == 1) {
                   up.add(i);
                   horizontal.add(j);//wrong 1 all the ones be should in the list!
               }
           }
       }

       if (up.size() == 0) {
           return 0;
       }
        
       Collections.sort(up);
       Collections.sort(horizontal);

       int midUp = up.get((up.size() - 1)/2);
       int midHo = horizontal.get((horizontal.size() - 1)/2);

       int total = 0;

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    total += Math.abs(midHo - j) + Math.abs(midUp - i);
                }
            }
        }

        return total;
    }
}
