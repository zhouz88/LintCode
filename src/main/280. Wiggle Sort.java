class Solution {
    public void wiggleSort(int[] nums) {
       for (int i = 0; i + 1 < nums.length; i += 2) {
           if (nums[i] > nums[i + 1]) {
               swap(i, i + 1, nums);
           } 
           if (i + 2 >= nums.length) continue;
           if (nums[i + 1] < nums[i + 2]) {
               swap(i + 1, i + 2, nums);
           }
       }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
