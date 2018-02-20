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
