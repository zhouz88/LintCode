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

class Solution{
public int findNthDigit(int n) {

		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
}
