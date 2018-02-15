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
/*
296. Best Meeting Point
DescriptionHintsSubmissionsDiscussSolution
Pick One
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.


*/
