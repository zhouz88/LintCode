274. H-Index
class Solution {
    public int hIndex(int[] citations) {
        int l = 0, r = citations.length;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (check(mid, citations) >= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private int check(int mid, int[] citations) {
        int cnt = 0;
        for (int num:citations) {
            if (num >= mid) {
                cnt++;
            }
        }
        return cnt;
    }
}
