class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
         if (word1.equals(word2)) {
             int pre = -1;
             int min = 99999999;
             int i = 0;
             for (String k : words) {
                 if (k.equals(word1)) {
                     if (pre != -1) {
                         min = Math.min(min, i - pre);
                     }
                     pre = i;
                 }
                 i++;
             }
             return min;
         } else {
             int pre1 = -1;
             int pre2 = -1;
             int min = 99999999;
             int i = 0;
             for (String k : words) {
                 if (k.equals(word1)) {
                     if (pre2 != -1) {
                         min = Math.min(min, i - pre2);
                     }
                     pre1 = i;
                 }
                 if (k.equals(word2)) {
                     if (pre1 != -1) {
                         min = Math.min(min, i - pre1);
                     }
                     pre2 = i;
                 }
                 i++;
             }
             return min;
         }
    }
}
