class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int l = 0, r = nums.length - 1;
        
        if (nums[l] < nums[r]) {//no rotation
            int idx = Arrays.binarySearch(nums, 0 , nums.length, target);
            if (idx < 0) {
                return false;
            }
            return true;
        }
        
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] > nums[0]) { //how to make sure is left?
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } 
            
            if (nums[mid] < nums[nums.length - 1]) {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            
            if (nums[mid] == nums[l]) {
                l++;
            } else if (nums[mid] == nums[r]){
                r--;
            }
            
        }

        return false;
    }
}

//no du
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int l = 0, r = nums.length - 1;
        
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[mid] >= nums[0]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            if (nums[mid] <= nums[nums.length - 1]) {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        
        return -1;
    }
}
