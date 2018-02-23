import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] a) {
        if (a == null || a.length < 2)
            return 0;
        int m = a.length;
        int max = a[0];
        int min = a[0];
        for (int k : a) {
            max = Math.max(max, k);
            min = Math.min(min, k);
        }
        int gap = (int)Math.ceil((1.0* max - 1.0* min)/(m - 1));

        int[] bucketsMin = new int[m - 1];
        int[] bucketsMax = new int[m - 1];
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);

        for (int i = 0; i < a.length; i++) {
            if (a[i] == min || a[i] == max) {
                continue;
            }
            int idx = (a[i] - min)/gap;//本质上是用CPU 计算换区排序速度。
            bucketsMax[idx] = Math.max(bucketsMax[idx], a[i]);
            bucketsMin[idx] = Math.min(bucketsMin[idx], a[i]);
        }
//bucket 肯定同时有值
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < a.length - 1; i++) {
            if (bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMin[i] - previous);
            // update previous bucket value
            previous = bucketsMax[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}
