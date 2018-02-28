class Solution {
    public int maximumSwap(int num) {
       char[] t = String.valueOf(num).toCharArray();
       char[] dp = new char[t.length];
       dp[t.length - 1] = t[t.length - 1];
       for (int i = t.length - 2; i >= 0; i--) {
           dp[i] = dp[i + 1] > t[i] ? dp[i + 1] : t[i];
       }
       for (int i  =0; i < dp.length; i++) {
           if (dp[i] != t[i]) {
               for (int j = t.length - 1; j >= 0; j--) {
                   if (t[j] == dp[i]) {
                       char tmp = t[j];
                       t[j] = t[i];
                       t[i] = tmp;
                       return Integer.parseInt(new String(t));
                   }
               }
           }
       }
       return num;
    }
}
