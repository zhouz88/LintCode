public class Solution {
    /*
     138. Subarray Sum

    Description
    Notes
    Testcase
    Judge

Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.
Notice

There is at least one subarray that it's sum equals to zero.
Have you met this question in a real interview?
Example

Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
Tags 
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        if (nums == null || nums.length == 0)
            throw new RuntimeException();
            
        map.put(0, -1);
        
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (map.containsKey(total)) {
                int start = map.get(total);
                res.add(start + 1);
                res.add(i);
                return res;
            } else {
                map.put(total, i);
            }
        }
        return res;
    }
}
