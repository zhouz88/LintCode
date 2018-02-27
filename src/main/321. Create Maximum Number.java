class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for(int i = 0; i <= k; i++) {
            if (i > nums1.length || k - i > nums2.length) continue;
            int[] max1 = maxArray(nums1, i);
            int[] max2 = maxArray(nums2, k - i);
            int[] ret = new int[k];
            int l = 0, r = 0;
            int idx = 0;
            while (l < i && r < k - i) {
                if (max1[l] < max2[r]) {
                    ret[idx++] = max2[r++];
                } else if (max1[l] > max2[r]){
                    ret[idx++] = max1[l++];
                } else {
                    int I = l, J = r;
                    while (I < i && J < k - i && max1[I] == max2[J]) {
                        I++;
                        J++;
                    }//2 9 and 2 1 might be 2291 2921
                    if (J == k - i || (I < i && max1[I] > max2[J])) {
                        ret[idx++] = max1[l++];
                    } else {
                        ret[idx++] = max2[r++];
                    }
                }
            }
            while (l < i) {
                ret[idx++] = max1[l++];
            }
            while (r < k - i) {
                ret[idx++] = max2[r++];
            }
            for (int j = 0; j < k; j++) {
                if (ret[j] < res[j]) {
                    break;
                } else if (ret[j] > res[j]) {
                    res = ret;
                    break;
                }
            }
        }
        return res;
    }

    public int[] maxArray(int[] nums, int k) {
        int[] stk = new int[nums.length];
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (idx == -1|| nums.length - i + idx + 1 == k) {
                stk[++idx] = nums[i];
            } else if (nums.length - i + idx + 1 > k) {
                while (idx != -1 && nums.length - i + idx >= k && stk[idx] < nums[i]) {
                    stk[idx--] = 0;
                }
                if (idx < k) stk[++idx] = nums[i];
            }
        }
        return stk;
    }
}
