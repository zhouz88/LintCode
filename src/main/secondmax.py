class Solution:
    """
    @param: : An integer array
    @return: The second max number in the array.
     479. Second Max of Array

    Description
    Notes
    Testcase
    Judge

Find the second max number in a given array.
Notice

You can assume the array contains at least two numbers.
Have you met this question in a real interview?
Example

Given [1, 3, 2, 4], return 3.

Given [1, 2], return 1.

    """

    def secondMax(self, nums):
        # write your code here
        low, high, k = 0, len(nums) - 1, 1
        
        while low <= high:
            pivot = nums[high]
            idx = low - 1
            for i in range(low, high):
                if nums[i] > pivot:
                    idx +=1
                    self.swap(nums, i, idx)
            idx += 1
            self.swap(nums, idx, high)
            
            if idx == k:
                return nums[k]
            
            if idx > k:
                high = idx - 1
            else:
                low = idx + 1
                
        return 1
        
        
    def swap(self, nums, i, j):
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
