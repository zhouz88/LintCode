/**
* 本参考程序来自九章算法，由 @九章算法 提供。版权所有，转发请注明出处。
* - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
* - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，
* - Big Data 项目实战班，算法面试高频题班, 动态规划专题班
* - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code
461. Kth Smallest Numbers in Unsorted Array 
 Description
 Notes
 Testcase
 Judge
Find the kth smallest numbers in an unsorted integer array.

Have you met this question in a real interview? Yes
Example
Given [3, 4, 1, 2, 5], k = 3, the 3rd smallest numbers are [1, 2, 3].

Challenge 
Tags 
Related Problems 
*/ 

class Solution {
    /*
     * @param k an integer
     * @param nums an integer array
     * @return kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        if (nums == null || k > nums.length)
            throw new RuntimeException();
        
        int r = nums.length - 1;
        int l = 0;
        
        while (l <= r) {
            int pivot = nums[r];
            int idx = l - 1;
            for (int i = l; i <= r; i++) 
                if (nums[i] < pivot) 
                     swap(nums, ++idx, i);
                     
            swap(nums, ++idx, r);
            
            if (idx == k - 1) 
                return nums[idx];
                
            if (idx < k - 1) 
                l = idx + 1;
            else 
                r = idx - 1;
            
        }
        
        throw new RuntimeException();
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
