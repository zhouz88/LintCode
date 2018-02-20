class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1, j = i;
        
        int len = nums.length;
        
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        
        if (i == 0) {
            for (int k = 0; k <= (len - 1)/2; k++) {
                swap(k, len - 1 - k, nums);
            }
            return;
        }
        
        while (j > 0 && nums[j] <= nums[i - 1]) {
            j--;
        }
        
        swap(i - 1, j, nums);
        
        for (j = i; j <= i + (len - i)/2 - 1; j++) { //wrong 1
            swap(j, len - 1 - j + i, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}


//2
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1, j = i;
        
        int len = nums.length;
        
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        
        if (i == 0) {
            reverse(0, len - 1, nums);
            return;
        }
        
        while (j > 0 && nums[j] <= nums[i - 1]) {
            j--;
        }
        
        int tmp = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = tmp;
        
        reverse(i, len - 1, nums);
    }

    private void reverse(int i, int j, int[] nums) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
