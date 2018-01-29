public class Solution {
    /*
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here
        int i;
        int[] ret = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (i = 0; i < nums.length; i++) {
            if (i <= k - 1) {
                pq.add(nums[i]);
            } else {
                if (pq.peek() >= nums[i]) {
                    continue;
                } else{
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        
        i = 0;
        while(!pq.isEmpty()){
            ret[i++] = pq.poll();
        }
        
        for (i = 0; i <= (ret.length - 1)/2; i++) {
            int tmp = ret[i];
            ret[i] = ret[ret.length - 1 - i];
            ret[ret.length - 1 - i] = tmp;
        }
        return ret;
    }
}
