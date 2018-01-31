import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    /*
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        Integer[] idx = new Integer[nums.length];
        int i;
        
        for (i = 0; i < nums.length;i++) {
            idx[i] = i;
        }
        
        Comparator<Integer> valComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o1] - nums[o2];
            }
        };
        
        int[] ret = new int[2];
        Arrays.sort(idx, valComparator);
        int l = 0, r = idx.length - 1;
        
        while (l < r) {
            int total = nums[idx[l]] + nums[idx[r]];
            if (total == target) {
                ret = new int[] {idx[l], idx[r]};
                break;
            } else if (total > target) {
                r--;
            } else {
                l++;
            }
        }
        
        Arrays.sort(ret);
        return ret;
    }
}
