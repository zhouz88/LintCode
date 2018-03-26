/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int idx = 0;
        char[] temp = new char[4];
        int pointer = 0;
        int cnt = 0;
        while (idx < n) {
            cnt = read4(temp);
            if (cnt == 0) break;
            while (pointer < cnt && idx < n) {
                buf[idx++] = temp[pointer++];
            }
            if (pointer == cnt) {
                pointer = 0;
            }
        }
        return idx;
    }
}

//
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] temp = new char[4];
    private int pointer = 0;
    private int cnt = 0;
    
    public int read(char[] buf, int n) {
         int idx = 0;
         while (idx < n) {
             if (pointer == 0) {
                 cnt = read4(temp);
             }
             if (cnt == 0) break;
             while (pointer < cnt && idx < n) {
                 buf[idx++] = temp[pointer++];
             }
             if (pointer == cnt) {
                 pointer = 0;
             }
         }
         return idx;
    }
}
