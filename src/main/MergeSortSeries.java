327. Count of Range Sum
/*
327. Count of Range Sum
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.
*/
class Solution {
    
    private int count = 0, lower, upper;
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        sum[0] = 0;
        
        this.lower = lower;
        this.upper = upper;
        
        for (int i = 1; i <= nums.length; ++i) {
            sum[i] = sum[i - 1] + (long)nums[i - 1];
        }
       
        mergesort(sum, 0, sum.length - 1);
        return count;
    }
    
    private void mergesort(long[] sum, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergesort(sum, start, mid);
        mergesort(sum, mid + 1, end);
        merge(sum, start, mid, end);
    }
    
    private void merge(long[] sum, int start, int mid, int end) {
        long[] temp = new long[end - start + 1];
        int right = mid + 1;
        int index = start;
        int low = mid + 1, high = mid + 1;
        
        for (int left = start; left <= mid; ++left) {
            while (low <= end && sum[low] - sum[left] < lower) {
                ++low;
            }
            while (high <= end && sum[high] - sum[left] <= upper) {
                ++high;
            }
            while (right <= end && sum[right] < sum[left]) {
                temp[index++ - start] = sum[right++];
            }
            temp[index++ - start] = sum[left];
            count += high - low;
        }
        
        while (right <= end) {
            temp[index++ - start] = sum[right++];
        }
        
        for (int i = start; i <= end; ++i) {
            sum[i] = temp[i - start];
        }
    }  
}
/*
315. Count of Smaller Numbers After Self
DescriptionHintsSubmissionsDiscussSolution
Pick One
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
*/
class Solution {
	private static int[] count;
	
    public static List<Integer> countSmaller(int[] nums) {
    	List<Integer> result = new ArrayList<Integer>();
    	
    	count = new int[nums.length];
    	int[] index = new int[nums.length];
    	
    	for (int i = 0; i < nums.length; i++) {
    		index[i] = i;
    	}
    	
        mergesort(nums, index, 0, nums.length - 1);
        
        for (int i = 0; i < count.length; i++){
        	result.add(count[i]);
        }
    	return result;
    	
    }
    
    private static void mergesort(int[] nums, int[] index, int start, int end) {
    	
    	if (start < end) {
    		int mid = (start + end) / 2;
    	
    		mergesort(nums, index, start, mid);
    		mergesort(nums, index, mid+1, end);
    		
    		merge(nums, index, start, mid, end);
    	}
    }
    
    private static void merge(int[] nums, int[] index, int start, int mid, int end) {
    	int[] tmp = new int[end - start + 1];
		
		int i = start; 
		int j = mid + 1;
		int k = 0;
		int rightCount = 0;
		

		while (i <= mid && j <= end) {
			if (nums[index[j]] < nums[index[i]]) {
				tmp[k] = index[j];
				rightCount++;
				j++;
			} else {
				tmp[k] = index[i];
				count[index[i]] += rightCount;
				i++;
			}
			k++;
		}

		while (i <= mid) {
			tmp[k] = index[i];
			count[index[i]] += rightCount;
			k++;
			i++;
		}
		
		while (j <= end) {
			tmp[k] = index[j];
			k++;
			j++;
		}
		
		for (int m = start; m <= end; m++) {
			index[m] = tmp[m - start];
		}
    }
}
