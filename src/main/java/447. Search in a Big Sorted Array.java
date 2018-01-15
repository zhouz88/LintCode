public class Solution {
    /*
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int r = 1;
        while (reader.get(r) < target) {
            r = r + r;
        }
        int l = 0;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (reader.get(mid) >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return reader.get(l) == target ? l : -1;
    }
}
