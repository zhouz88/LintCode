class Solution {
    public int maxRotateFunction(int[] A) {
        //corner case
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int k : A) {
            sum += k;
        }
        
        int total = 0; //total is the value we calculate
        int max = -1;
        for (int i = 0;i < A.length; i++) {
            total += i * A[i];
            max = total;
        }
        
        for (int i = A.length - 1; i >= 0; i--) {
            total += sum;
            total -= A.length * A[i];
            max = Math.max(total, max);
        }
        
        return max;
    }
}
