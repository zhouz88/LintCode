 private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[end];

        int l = start, r = end;
        while (l <= r) {
            while (l <= r && nums[l] < pivot) {
                l++;
            }
            while (l <= r && nums[r] > pivot) {
                r--;
            }
            if (l <= r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }

        quickSort(nums, start, r);
        quickSort(nums, r + 1, end);
    }
