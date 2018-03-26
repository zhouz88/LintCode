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
        while (idx < n) {
            int cnt = read4(temp);
            if (cnt == 0) break;
            int pointer = 0;
            while (pointer < cnt && idx < n) {
                buf[idx++] = temp[pointer++];
            }
        }
        return idx;
    }
}
