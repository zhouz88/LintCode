class Solution {
    public int singleNonDuplicate(int[] nums) {
       if (nums == null || nums.length == 0) {
           return 0;
       }
       
       int l = 0, r = nums.length  - 1;
       while (l <= r) {
           int mid = ((r - l) >> 1) + l;
           if ((mid == 0 || nums[mid - 1] != nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] != nums[mid])) {
               return nums[mid];
           }
           
           if (mid%2 == 0) {
               if (mid < nums.length - 1 && nums[mid] != nums[mid + 1]) {
                   r = mid - 1;
               } else  {
                   l = mid + 1;
               }
           } else {
               if (mid > 0 && nums[mid] == nums[mid - 1]) {
                   l = mid + 1;
               } else if (mid > 0) {
                   r = mid - 1;
               }
           }
       }
       return -1;
    }
}
