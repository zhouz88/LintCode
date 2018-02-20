class Solution {
    public boolean isPalindrome(String s) {
       s = s.toLowerCase();
       int i = 0, j = s.length() - 1;
       while (i <= j) {
           while (i <= j && !isLorD(s.charAt(i))) {
               i++;
           }
           while (i <= j && !isLorD(s.charAt(j))) {
               j--;
           }
           if (i <= j && s.charAt(i) == s.charAt(j)) {
               i++;
               j--;
           } else if (i <= j && s.charAt(i) != s.charAt(j)){
               return false;
           } 
       }
       return true;
    }
    
    private boolean isLorD(char ch) {
        return (ch>='a'&& ch<='z')|| (ch>='0'&&ch<='9');
    }
}


class Solution {
    public boolean isPalindrome(String s) {
        char[] t = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            
            while (i < j && !isLorD(t[i])) {
                i++;
            }
            while (i < j && !isLorD(t[j])) {
                j--;
            }
            if (i < j) {
                if (Character.toLowerCase(t[i]) != Character.toLowerCase(t[j]) ) {
                    return false;
                } 
                i++;
                j--;
            }
        }
        
        return true;
    }

    public boolean isLorD(char ch) {
        return (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }
}
