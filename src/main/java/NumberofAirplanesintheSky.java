/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 391. Number of Airplanes in the Sky 

 Description
 Notes
 Testcase
 Judge
Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

 Notice

If landing and flying happens at the same time, we consider landing should happen at first.

Have you met this question in a real interview? Yes
Example
For interval list

[
  [1,10],
  [2,3],
  [5,8],
  [4,7]
]
Return 3
 */

import java.util.*;

public class Solution {
    /*
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here

        List<Point> list = new ArrayList<>();
        for (Interval e : airplanes) {
            list.add(new Point(e.start, 1));
            list.add(new Point(e.end, 0));
        }

        Collections.sort(list);
        int count = 0;
        int max = 0;
        for (Point k : list) {
            if (k.isStart == 1) {
                count++;
            } else {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    class Point implements Comparable<Point> {
        int val;
        int isStart;

        public Point(int val, int bo) {
            this.val = val;
            this.isStart = bo;
        }

        @Override
        public int compareTo(Point b) {
            if (val == b.val) {
                return isStart - b.isStart;
            }
            return val - b.val;
        }
    }
}
