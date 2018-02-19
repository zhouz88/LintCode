import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        Comparator<String> valComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        };
        
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = "" + nums[i];
        }
        Arrays.sort(strs, valComparator);
        StringBuilder sb = new StringBuilder();
        for (String k : strs) {
            sb.append(k);
        }
        String ret = sb.toString();
        int idx = 0;
        
        while (idx < ret.length() && ret.charAt(idx) == '0') {
            idx++;
        }
        
        return ret.substring(idx).equals("") ? "0" : ret.substring(idx);
    }
}
