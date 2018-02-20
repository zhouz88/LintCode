import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        char[] t = s.toCharArray();
        HashMap<String, Integer> map = new HashMap<>();
        int len = words[0].length();
        
        int total = len * words.length;
        
        for (String k : words) {
            map.put(k, map.getOrDefault(k,0) + 1);
        }
        
        List<Integer> ret = new ArrayList<>();
        
        int start, i, j;

        HashMap<String, Integer> window = new HashMap<>();;
        
        for (start = 0; start < len; start++) { //wrong 1
            window.clear();
            checkStartFrom(start, window, t, map, len, total, ret);
        }
        
        return ret;
    }

    private void checkStartFrom(int start, HashMap<String, Integer> window, char[] t, HashMap<String, Integer> map, int len, int total, List<Integer> ret) {
        for (int i = start; i + len <= t.length; i += len) {
            String inWindow = String.valueOf(t, i, len);
            window.put(inWindow, window.getOrDefault(inWindow, 0) + 1);
            // System.out.println(inWindow);
            if (i + len - total >= start) { //wrong 2
                if (window.equals(map)) {
                    ret.add(i - total + len);
                }
                String outWindow = String.valueOf(t, i + len - total, len); //wrong 3
                int tmp = window.get(outWindow);
                if (tmp == 1) {
                    window.remove(outWindow);
                } else {
                    window.put(outWindow, window.get(outWindow) - 1);
                }
            }
        }
    }
}
