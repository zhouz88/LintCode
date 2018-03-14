public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int pointer = 0;
    private char[] temp = new char[4];
    private int count = 0;

    public int read(char[] buf, int n) {
        int idx = 0;
        while (idx < n) {
            if (pointer == 0) {
                count = read4(temp);
            }
            if (count == 0) break;
            while (idx < n && pointer < count) {
                buf[idx++] = temp[pointer++];
            }
            if (pointer == count) {
                pointer = 0;
            }
        }
        return idx;
    }
}
