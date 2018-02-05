public class Solution {
    /*
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if ((long)mid*mid - x == 0) {
                return mid;
            } else if ((long)mid*mid  < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
Binary search(l <= r)
如果不含有target;
l 是第一个大于target得数；
r 是第一个小于target的数；
