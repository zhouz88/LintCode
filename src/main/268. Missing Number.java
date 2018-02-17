268. Missing Number

class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int k : nums) {
            sum += k;
        }
        return (nums.length + 1) * nums.length/2 - sum;
    }
}
