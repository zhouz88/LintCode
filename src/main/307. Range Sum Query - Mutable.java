class NumArray {
    
    private int[] Bit;
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.Bit = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            init(i, nums[i]);
        }
    }
    
    public void init(int i, int val) {
		i++;
		while (i < Bit.length) {
			Bit[i] += val;
			i += (i & -i);
		}
	}

    public void update(int i, int val) {
        updateTree(i, val - nums[i]);
        nums[i] = val;
    }

    private void updateTree(int i, int val) {
        i++;
        while (i < Bit.length) {
            Bit[i] += val;
            i += (-i & i);
        }
    }

    public int sumRange(int i, int j) {
         return getSum(j) - getSum(i - 1);
    }
    
    private int getSum(int i) {
        i++;
        int sum = 0;
        while (i > 0) {
            sum += Bit[i];
            i -= (-i & i);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
