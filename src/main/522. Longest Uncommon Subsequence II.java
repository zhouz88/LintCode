import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findLUSlength(String[] strs) {
        class valComparator implements Comparator<String> {

            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }

        Arrays.sort(strs, new valComparator());
        
        int max = -1,  i, j;
        for (i = 0; i < strs.length; i++) {
            String k = strs[i];
            int tmp = 0;
            boolean flag = false;
            for (j = 0; j < strs.length; j++) {
                if (strs[j].length() < k.length() || i == j) continue;
                if (get(k, strs[j]) == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                max = Math.max(k.length(), max);
            }
        }
        return max;
    }

    private int get(String k, String str) {
        int i = 0, j = 0;
        while (i < str.length()) {
            if (str.charAt(i) == k.charAt(j)) {
                i++;
                j++;
                if (j == k.length()) {
                    return 0;
                }
            } else {
                i++;
            }
        }
        return k.length();
    }
}
