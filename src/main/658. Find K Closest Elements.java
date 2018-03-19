import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int l = 0, r = n - k;
        while (l <= r) {
            int mid = (r - l)/2 + l;
            if (mid + k == n || arr[mid + k] + arr[mid] >= 2 * x) {
                r = mid - 1;
            } else if (arr[mid + k] + arr[mid] < 2 * x) {
                l = mid + 1;
            }
        }
        for (int i = l ; i < l + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
