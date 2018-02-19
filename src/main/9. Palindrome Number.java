class Solution {
   public boolean isPalindrome(int x) {
        int palindromeX = 0;
        int inputX = x;
        while(x>0){
            palindromeX = palindromeX*10 + (x % 10);
            x = x/10;
        }
        return palindromeX==inputX;	
    }
}
