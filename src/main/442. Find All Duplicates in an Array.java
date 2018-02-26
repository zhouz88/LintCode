import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
       int i = 0;
       while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    res.add(nums[i]);
                    nums[i++] = -1;
                    continue;
                }
                swap(nums, nums[i] - 1, i);
                if (nums[i] == -1) {
                    i++;
                }
            } else {
                i++;
            }
        }
        return res;
    }

    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
