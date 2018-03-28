class Solution {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int l = 0, i = 0;
        int r = nums.length -1;
        int n = nums.length;
        while (i <= r) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(l++, n), newIndex(i++, n));
            }else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(r--, n), newIndex(i, n));
            }else i++;
        }
    }
    
    private int newIndex(int i, int n) {
        return (2*i+1) % (n | 1);
    }
    
   public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        int pivot = nums[end];
        int idx = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, ++idx);
            }
        }
        swap(nums, end, ++idx);
        if (idx == k - 1) {
            return nums[idx];
        }
        if (idx < k - 1) {
            return quickSelect(nums, idx + 1, end, k);
        } else {
            return quickSelect(nums, start, idx - 1, k);
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }
}
