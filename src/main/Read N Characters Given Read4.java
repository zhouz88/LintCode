public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int offset = 0;
        
        while (true) {
            int size = read4(buf4);
            for (int i = 0; i < size && offset < n; i++) {
                buf[offset++] = buf4[i];
            }
            if (size == 0 || offset == n) {
                return offset;
            }
        }
    }
}
