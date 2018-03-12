class Solution { //11111111111 可以表示所有数组//missing 到当前为止最小不能表示数。
    //1 2 4 8 16 .....政体平移5
    public int minPatches(int[] nums, int n) {
        long missing = 1;
        int i = 0;
        int cnt = 0;
        while (missing <= n) {
            if (i < nums.length && nums[i] <= missing) {
                missing += nums[i];
                i++;
            } else {
                cnt++;
                missing += missing ;
            }
        }
        return cnt;
    }
}
