
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (total%k != 0) {
            return false;
        } 
        if (k == 1)  {
            Arrays.sort(nums);
            return nums[0] == nums[nums.length - 1];
        }
        int sum = total/k;
        int state = (1 << (nums.length)) - 1;
        //System.out.println(Integer.toBinaryString(state) + ":" + sum); //wrong 1;
        return dfs(state, nums, k, 0 , sum);
    }

    private Map<String, Boolean> map  = new HashMap<>();

    private boolean dfs(int state, int[] nums, int k, int sum, int average) {
        if (sum > average) {
            return false;
        }

        if (sum == average) {
            k--;
            String tmp = state + " " + k + " " + 0;
            if (map.containsKey(tmp)) {
                return map.get(tmp);
            }
            if (k == 1) {
                map.put(tmp, true);
                return true;
            } else {
                boolean flag =  dfs(state, nums, k, 0, average);//worng 1
                map.put(tmp, flag);
                return flag;
            }
        }
        String tmp = state + " " + k + " " + sum;
        
        if (map.containsKey(tmp)) {
            return map.get(tmp);
        }
        
        boolean flag = false;
        
        for (int i = 0; i < nums.length; i++) {
            if ((state & (1 << i)) == 0) {
                continue;
            } else {
                state ^= (1 << i);
                sum += nums[nums.length - i - 1];
                if (dfs(state, nums, k, sum, average)) {
                    flag = true;
                    break;
                }
                state |= (1 << i);
                sum -= nums[nums.length - i - 1];
            }
        }
        map.put(tmp, flag);
        return flag;
    }
}
