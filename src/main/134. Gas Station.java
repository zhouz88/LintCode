import java.util.Arrays;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        boolean[] notStart = new boolean[gas.length];
        int delta = 0;
        int start = 0;
        int i = 0;
        boolean flag = false;
        while (true) {
            flag = false;
            delta += gas[i] - cost[i];
            if (delta < 0) {
                int j = start;
                while (j != i) {
                    if (notStart[j]) return -1;
                    notStart[j] = true;
                    j = (j + 1) % gas.length;
                }
                if (notStart[j]) return -1;
                notStart[j] = true;
                delta = 0;
                start = (i + 1) % gas.length;
                flag = true;
            }
            i = (i + 1) % gas.length;
            if (i == start && !flag) return i;
        }
    }
}
