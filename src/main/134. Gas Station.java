class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        boolean[] notStart = new boolean[gas.length];
        int n = gas.length, delta = 0;
        int i = 0, j = 0;

        while (j != n) {
            delta += gas[i] - cost[i];
            if (delta < 0) {
                while (j != i) {
                    if (notStart[j]) return -1;
                    notStart[j] = true;
                    if (++j == n) return -1;
                }
                if (notStart[j]) return -1;
                notStart[j] = true;
                j++;
                delta = 0;
                i = (i + 1) % n;
            } else {
                i = (i + 1) % n;
                if (i == j) return j;
            }
        }
        return -1;
    }
}


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, delta = 0;
        int i = 0, j = 0;

        while (j != n) {
            delta += gas[i] - cost[i];
            if (delta < 0) {
                if (i < j) return -1;
                j = i + 1;
                delta = 0;
                i = (i + 1) % n;
            } else {
                i = (i + 1) % n;
                if (i == j) return j;
            }
        }
    }
}


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, delta = 0;
        int i = 0, j = 0;

        while (j != n) {
            delta += gas[i] - cost[i];
            if (delta < 0) {
                if (i < j) return -1;
                delta = 0;
                j = ++i;
            } else {
                i = (i + 1) % n;
                if (i == j) return j;
            }
        }
        return -1;
    }
}
