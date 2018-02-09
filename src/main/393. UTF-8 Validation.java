class Solution {
    //multiple data consequence 
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            if ((data[i] & ONE_BYTE) == 0b00000000) {
                if (!check(data, i, 0)) {
                    return false;
                }
                i = i + 1;
            } else if ((data[i] & TWO_BYTE) == 0b11000000) {
                if (!check(data, i, 1)) {
                    return false;
                }
                i += 2;
            } else if ((data[i] & THREE_BYTE) == 0b11100000) {
                if (!check(data, i, 2)) {
                    return false;
                }
                i += 3;
            } else if ((data[i] & FOUR_BYTE) == 0b11110000) {
                if (!check(data, i, 3)) {
                    return false;
                }
                i += 4;
            } else {
                return false;
            }
        }
        return true;
    }
    
    private boolean check(int[] data, int start, int len) {
        if (start + len > data.length) {
            return false;
        }
        for (int i = 1; i <= len; i++) {
            if ((data[i + start] & CONTENT_BYTE) != 0b10000000) {
                return false;
            }
        }
        return true;
    }

    private static final int ONE_BYTE = 0b10000000;
    private static final int TWO_BYTE = 0b11100000;
    private static final int THREE_BYTE = 0b11110000;
    private static final int FOUR_BYTE = 0b11111000;
    private static final int CONTENT_BYTE = 0b11000000;
}
