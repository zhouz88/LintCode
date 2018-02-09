public class Solution {
    /**
     * @param k:
     * @return: the sum of first k even-length palindrome numbers
     */
    public int sumKEven(int k) {
        // Write your code here
        int total = 0;
        for (int i = 1; i <= k; i++) {
            total += get(i);
        }
        return total;
    }
    
    private int get(int i) {
        char[] t = (""+i).toCharArray();
        for (int j =  0; j <= (t.length - 1)/2; j++) {
            char tmp = t[j];
            t[j] = t[t.length - 1- j];
            t[t.length - 1 - j] = tmp;
        }
        int len = t.length;
        return i * (int)Math.pow(10, len) + Integer.parseInt(new String(t));
    }
}
