import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        Integer[] ret = new Integer[nums.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = nums.get(i);
        }
        int i = ret.length - 1, j = i;

        while (i > 0 && ret[i - 1] <= ret[i]) {
            i--;
        }
        if (i == 0) {
            Collections.reverse(nums);
            return nums;
        }
        while (ret[j] - ret[i - 1] >= 0) {
            j--;
        }
        swap(ret, j, i - 1);
        Arrays.sort(ret, i, ret.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        return Arrays.asList(ret);
    }
    
    private void swap(Integer[] A, int i, int j) {
        Integer tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
