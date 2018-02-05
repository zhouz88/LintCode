public class Solution {
    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null 
              || source.length() < target.length()) {
            return -1;
        } 
        
        if ("".equals(target)) {
            return 0;
        }
        
        for (int i = 0; i <= source.length() - target.length(); i++) {
            String tmp = source.substring(i, target.length() + i);
            if (tmp.equals(target)) {
                return i;
            }
        }
        
        return -1;
    }
}
