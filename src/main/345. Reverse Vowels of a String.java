class Solution {
    public String reverseVowels(String s) {
        //corner case
        if (s == null) {
            return null;
        }
         int m = s.length();
         if (m == 0) {
             return s;
         }
         
         char[] t = s.toCharArray();
         int l = 0, r = s.length() - 1;
         
         while (l <= r) {
             while (l <= r && !isVowel(t[l])) {
                 l++;
             }
             while (l <= r && !isVowel(t[r])) {
                 r--;
             }
             if (l <= r) {
                 char tmp = t[l];
                 t[l] = t[r];
                 t[r] =tmp;
                 l++;
                 r--;
             }
         }
         
         return new String(t);
    }
    
    private boolean isVowel(char ch) {
        String a = "aeiou";
        return a.indexOf(Character.toLowerCase(ch)) != -1; 
    }
}
