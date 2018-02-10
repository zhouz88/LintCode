157. Read N Characters Given Read4157. Read N Characters Given Read4
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); 
      157. Read N Characters Given Read4
DescriptionHintsSubmissionsDiscussSolution

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case. */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] ch = new char[4];
        //n can be larget than file and file also can be small than n
        int i = 0;
        while (i < n) { //should be i < n not true cause n can be 0
            int size = read4(ch);
            if (size == 4) {
                for (int j = 0; j < 4; j++) {
                    buf[i++] = ch[j];
                    if (i == n) {
                        break;
                    }
                }
            } else {
                for (int j = 0; j < size; j++) {
                    buf[i++] = ch[j]; // care i == n;
                    if (i == n) {
                        break;
                    }
                }
                break;
            }
        }
        return i;
    }
}
