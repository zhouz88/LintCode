public class Solution {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        char[] t = s.trim().toCharArray();
        if (s.indexOf(" ") == -1) {
            return s;
        }
        swap(t, 0 , t.length - 1);
        int pre = 0;
        for (int i = 1; i < t.length; i++) {
            if (t[i] == ' ') {
                int start = i;
                while (i + 1 < t.length &&  t[i + 1] == ' ') {
                    i++;
                }
                swap(t, pre, start - 1);
            }
            if (t[i - 1] == ' ') {
                pre = i;
            }
        }
        swap(t, pre, t.length - 1);
        return new String(t);
    }
    
    void swap(char[] t, int i, int j) {
        int mid = i + ((j - i) >> 1);
        int start;
        for (start = i; start <= mid; start++) {
            char tmp = t[start];
            t[start] = t[j - start + i];
            t[j - start + i] = tmp;
        }
    }
}
