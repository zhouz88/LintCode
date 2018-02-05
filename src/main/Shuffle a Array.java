import java.util.Arrays;
import java.util.Random;

class Solution {
    private int[] array;
    Random random;
    
    public Solution(int[] nums) {
        this.array = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ret = Arrays.copyOf(array, array.length);
        for (int i = 0; i < ret.length; i++) {
            int idx = random.nextInt(ret.length - i);
            int next = idx + i;
            swap(ret, next, i);
        }
        return ret;
    }
    
    private void swap(int[] ret, int i, int j) {
        int tmp = ret[i];
        ret[i] = ret[j];
        ret[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
