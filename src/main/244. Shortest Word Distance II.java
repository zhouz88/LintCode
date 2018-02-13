import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordDistance {
    Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        int i = 0;
       for (String k : words) {
           map.putIfAbsent(k, new ArrayList<>());
           map.get(k).add(i);
           i++;
       }
    }

    public int shortest(String word1, String word2) {
        List<Integer> word1List = map.get(word1);
        List<Integer> word2List = map.get(word2);
        int idx1 = 0;
        int idx2 = 0;
        int min = 99999999;
        while (idx1 < word1List.size() && idx2 < word2List.size()) {
            if (word1List.get(idx1) < word2List.get(idx2)) {
                min = Math.min(min, word2List.get(idx2) - word1List.get(idx1));
                idx1++;
            } else {
                min = Math.min(min, word1List.get(idx1) - word2List.get(idx2));
                idx2++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
