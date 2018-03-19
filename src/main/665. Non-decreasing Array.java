class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        int start = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                cnt++;
                if (cnt == 1) start = i;
                if (cnt > 1) {
                    return false;
                }
            }
        }

        if (cnt == 0) {
            return true;
        }
        
        if (start == 0 || start + 1 == nums.length - 1) {
            return true;
        }
        
        return !(nums[start - 1] > nums[start + 1] && nums[start] > nums[start + 2]);
    }
}
