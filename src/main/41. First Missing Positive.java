class Solution {
    public int firstMissingPositive(int[] nums) { 
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) {
                continue;
            } else if (nums[i] <= 0 || nums[i] > n) {
                continue;
            } else {
                int tmp = nums[i];
                nums[i] = 0;
                dfs(tmp, nums);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void dfs(int tmp, int[] nums) {
        if (nums[tmp - 1] <= 0 || nums[tmp - 1] > nums.length || nums[tmp - 1] == tmp) {
            nums[tmp - 1] = tmp;
            return;
        } else {
            int tmp0 = nums[tmp - 1];
            nums[tmp - 1] = tmp;
            dfs(tmp0, nums);
        }
    }
}
//
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] <= n && nums[i] != i + 1) {
                int temp = nums[i];
                nums[i] = 0;
                while (nums[temp - 1] > 0 && nums[temp - 1] <= n && nums[temp - 1] != temp) {
                    int next = nums[temp - 1];
                    nums[temp - 1] = temp;
                    temp = next;
                }
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < n ;i ++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
