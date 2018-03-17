import java.util.*;

class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        Map<String, List<Integer>> map = new HashMap<>();
        int[] col = new int[picture[0].length];
        int[] row = new int[picture.length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j]== 'B') {
                    col[j]++;
                    row[i]++;
                }
            }
        }
        for (int i = 0; i < picture.length; i++) {
            String t = Arrays.toString(picture[i]);
            map.putIfAbsent(t, new ArrayList<>());
            map.get(t).add(i);
        }
        int max = 0;
        for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
            if (e.getValue().size() != N) continue;
            List<Integer> list = e.getValue();
            int cnt = 0;
            int i = list.get(0);
            if (row[i] != N)continue;
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && col[j] == e.getValue().size()) {
                    cnt += e.getValue().size();
                }
            }
            max += cnt;
        }
        return max;
    }
}
