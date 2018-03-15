import java.util.HashMap;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {
        int[] map = new int[256];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (char ch : s.toCharArray()) {
            map[ch]++;
            min = Math.min(min, map[ch]);
            max = Math.max(max, map[ch]);
        }
        StringBuilder[] sb = new StringBuilder[max - min + 1];
        for (int i = 0; i < 256; i++) {
            if (map[i] == 0) continue;
            if (sb[map[i] - min] == null) {
                sb[map[i] - min] = new StringBuilder();
            }
            char tmp = (char) i;
            for (int j = 0; j < map[i]; j++) {
                sb[map[i] - min].append(tmp);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = sb.length - 1; i >= 0; i--) {
            if (sb[i] != null) {
                res.append(sb[i]);
            }
        }
        return res.toString();
    }
}
