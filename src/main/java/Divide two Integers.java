/*

cl29. Divide Two Integers
DescriptionHintsSubmissionsDiscussSolution

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT. 
*/
class Solution {
    public int divide(int dividend, int divisor) {
        final int MAX_VALUE = Integer.MAX_VALUE;
        final int MIN_VALUE = Integer.MIN_VALUE;
        
        long D = (long) dividend;
        long d = (long) divisor;
        
        long sign = getSign(D, d);
        D = Math.abs(D);
        d = Math.abs(d);
        
        if (d == 0) 
            return MAX_VALUE;
        
        long res = sign*get(D, d);
        return res <= MAX_VALUE && res >= MIN_VALUE ? (int) res : MAX_VALUE;
    }
    
    private long get(Long D, long d) {
        if (d > D)
            return 0;
        
        long total = d;
        long idx = 1; 
        while (total + total <= D) { // take care !!!!!!
            idx = idx + idx;
            total = total + total;            
        }
        
        return idx + get(D - total, d);
    }
    
    private int getSign(long a, long b) {
        int count=0;
        if (a<0) count++;
        if (b<0)count++;
        return count == 1 ? -1 : 1;
    }
}
