import java.util.ArrayDeque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        //edge case;
        if (nums == null || nums.length == 0 ) {
            return new int[]{};
        }
        
        //
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int i;
        int len = nums.length;
        int[] ret = new int[len - k + 1];
        int idx = 0;
        for (i = 0; i < len; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast(); // 进入 nums[i]的作用域后，之前小于这个数（最大K - 1）的都得滚！
                //the latter big one decides the max. nums[i]生命大于之前的数。就是说新来的数比旧的数都大， 旧的数就得淘汰。
            }
            dq.addLast(i);
            if (i - k + 1 >= 0) {
                ret[idx++] = nums[dq.peekFirst()]; //wrong 1
                if (dq.peekFirst() == i - k + 1) {
                    dq.pollFirst();
                }
            }
        }
        
        return ret;
    }
}
