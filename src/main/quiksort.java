

public class QuickSort{
    private QuickSort() {
        
    }
    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[end];

        int l = start, r = end;
        while (l <= r) {
            while (l <= r && nums[l] < pivot) { //l fast 比 r大的都是大于等于pivot的
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

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
