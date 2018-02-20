class Solution {
    public void sortColors(int[] nums) {
        int idxl = 0;
        int idxr = nums.length - 1;
        int i = 0;
        while (i <= idxr) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(idxl, i, nums);
                i++;
                idxl++;
            } else {
                swap(idxr, i, nums);
                idxr--;
            }
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
