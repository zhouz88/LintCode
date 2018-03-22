class Solution {
    public String convert(String s, int numRows) {
       if (numRows <= 1) {
           return s;
       }
       int len = 2 * numRows - 2;
       StringBuilder[] sb = new StringBuilder[numRows];
       for (int i = 0; i < sb.length; i++) {
           sb[i] = new StringBuilder();
       }
       int idx1 = 0;
       int idx2 = 0;
       for (int i = 0; i < s.length(); i++) {
           if (idx1 < numRows) {
               idx1++;
               sb[idx2++].append(s.charAt(i));
           } else {
               idx1++;
               idx2--;
               sb[idx2 - 1].append(s.charAt(i));
           }
           if (idx1 == len) {
               idx1 = 0;
               idx2 = 0;
           }
       }
       StringBuilder res = new StringBuilder();
       for (int i = 0; i < sb.length; i++) {
           res.append(sb[i]);
       }
       return res.toString();
    }
}
