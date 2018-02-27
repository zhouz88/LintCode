
import java.util.Comparator;
import java.util.List;

class Solution {

    public String findLongestWord(String s, List<String> d) {

        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length()) == 0 ?
                        o1.compareTo(o2) : Integer.compare(o2.length(), o1.length());
            }
        });

        int max = 0;
        for (String K : d) {
            int tmp = getMax(s, K);
           if (tmp != 0) {
               return K;
           }
        }
        return "";
    }

    private int getMax(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                if (j == t.length()) {
                    return j;
                }
            } else {
                i++;
            }
        }
        return 0;
    }
}
