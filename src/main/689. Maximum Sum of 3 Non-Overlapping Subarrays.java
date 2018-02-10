class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] windowSum = new int[len];
        int[] windowSum2 = new int[len];
        int i, j;

        int sum = 0;
        for (i = 0; i < len; i++) {
            sum += nums[i];
            if (i - k + 1 >= 0) {
                windowSum[i] = sum;
                sum -= nums[i - k + 1]; //wrong 1 !!!!!!!!!!!!! should be sum!!
            }
        }

        sum = 0;
        for (i = len - 1; i >= 0; i--) {
            sum += nums[i];
            if (i <= len - k) {
                windowSum2[i] = sum;
                sum -= nums[i + k - 1];
            }
        }

        int[] minDp = new int[len];
        int[] maxDp = new int[len];

        int max = k - 1;
        minDp[k - 1] = k - 1;
        maxDp[len - k] = len - k;

        for (i = k - 1; i < len; i++) {
            if (windowSum[i] > windowSum[max]) {
                max = i;
                minDp[i] = max;
            } else {
                minDp[i] = max;
            }
        }

        max = len - k;
        for (i = len - k; i >= 0; i--) {
            if (windowSum2[i] >= windowSum2[max]) {
                max = i;
                maxDp[i] = max;
            } else {
                maxDp[i] = max;
            }
        }
        
        //
        int[] ret = new int[3];
        max = -1;

        for (i = 2*k - 1; i <= len - k - 1; i++) {
            
            int total = windowSum[i] + windowSum[minDp[i - k]] + windowSum2[maxDp[i + 1]];
            if (total > max) {
                ret[0] = minDp[i - k] - k + 1;
                ret[1] = i - k + 1;
                ret[2] = maxDp[i + 1];
                max = total;
            }
        }

        return ret;
    }
}
