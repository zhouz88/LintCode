class Solution {
    public int findNthDigit(int n) {
        long total = 9;
        long len = 1;
        while ( n - len*total > 0 ) {
            n -= len * total;
            len++;
            total *= 10;
        }
        long start = (long) Math.pow(10, len - 1);
        long end = (n - 1)/len + start;
        String res = ""+end;
        return res.charAt((int)((n - 1)%len)) - '0';//wrong 1
    }
}

class Solution {
    public int findNthDigit(int n) {
        long total = 9;
        int count = 1;
        long len = 1;
        while ( n - len*total > 0 ) {
            n -= len * total;
            len++;
            total*= 10;
            count*=10;
        }
        long end = (n - 1)/len + count;
        String res = ""+end;
        return res.charAt((int)((n - 1)%len)) - '0';//wrong 1
    }
}

