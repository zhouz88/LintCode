public class Solution {
    public void sortColors(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        int i = 0;
        int lIdx =0;
        int rIdx = a.length - 1;
        
        while (i <= rIdx) {
            if (a[i] == 0) {
                swap(a, i, lIdx);
                i++;
                lIdx++;
            } else if (a[i] ==  1) {
                i++;
            } else if (a[i] == 2) {
                swap(a, i, rIdx);
                rIdx--;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
       int tmp = a[i];
       a[i] = a[j];
       a[j] = tmp;
    }
}
