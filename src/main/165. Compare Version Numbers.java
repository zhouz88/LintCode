class Solution {//good problem TWO POINTERS & COMPARATOR
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int i = 0, j = 0;
        while (i < a.length &&  j < b.length) {
            int A = Integer.parseInt(a[i]);
            int B = Integer.parseInt(b[i]);
            if (Integer.compare(A, B) != 0) {
                return Integer.compare(A,B);
            }
            i++;
            j++;
        }
        while (i < a.length) {
            if (Integer.parseInt(a[i++]) != 0) {
                return 1;
            }
        }
        while (j < b.length) {
            if (Integer.parseInt(b[j++]) != 0) {
                return -1;
            }
        }
        return 0;
    }
}
