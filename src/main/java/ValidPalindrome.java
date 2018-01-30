public class Solution {
    /*
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        char[] charArray = s.toLowerCase().replaceAll("[^a-z1-9]" , "").toCharArray();
        for (int i = 0; i <= ((charArray.length - 1) >> 1); i++) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                return  false;
            }
        }
        return true;
    }
}
