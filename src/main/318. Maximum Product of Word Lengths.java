class Solution {
    public int maxProduct(String[] words) { 
        int len = words.length;
       int[] f = new int[len];
       int i, j;
       for (i = 0; i < len; i++) {
           f[i] = i;
       }
       int mask = 0xffffffff & (1 << 26);
       int[] map = new int[len];
       for (i = 0; i < words.length; i++) {
           int tmp = mask;
           for (char ch : words[i].toCharArray()) {
               int a = ch - 'a';
               tmp |= (1 << a);
           }
           map[i] = tmp;
       }
       int max = 0;
       for (i = 0; i < words.length; i++) {
           for (j = i + 1; j < words.length; j++) {
               if ((map[i] & map[j]) == mask) {
                   max = Math.max(max, words[i].length() * words[j].length());
               }
           }
       }
       return max;
    }
}
