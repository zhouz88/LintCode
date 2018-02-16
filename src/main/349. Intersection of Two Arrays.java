import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                list.add(nums1[i]);
                while (i + 1 < nums1.length && nums1[i + 1] == nums1[i]) {
                    i++;
                }
                while (j + 1 < nums2.length && nums2[j + 1] == nums2[j]) {
                    j++;
                }
                i++;
                j++;
            }
        }
        int[] ret = new int[list.size()];
        for (i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
