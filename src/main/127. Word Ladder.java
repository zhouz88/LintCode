import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         Map<String, Boolean> map = new HashMap<>();
         for (int i = 0; i < wordList.size(); i++) {
             map.put(wordList.get(i), false);
         }
         if (!map.containsKey(endWord)) {
             return 0;
         }
         Queue<String> q = new LinkedList<>();
         q.add(beginWord);
         map.put(beginWord, true);
        
         int step = 0;
         while (!q.isEmpty()) {
             step++;
             int size = q.size();
             for (int i = 0; i < size; i++) {
                 String node = q.poll();
                 if (node.equals(endWord)) {
                     return step;
                 }
                 List<String> neibors = getNotVisitedNeibors(map, node);
                 for (int t = 0; t < neibors.size(); t++ ) {
                     q.add(neibors.get(t));//wrong 1 should be t not i!!!!!!!!
                 }
             }
         }
         return 0;
    }
    
    private List<String> getNotVisitedNeibors(Map<String, Boolean> map, String node) {
        List<String> ret = new ArrayList<>();
        char[] arr = node.toCharArray();
        for (int i = 0; i < arr.length;i++) {
            char tmp = arr[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == tmp) {
                    continue;
                }
                arr[i] = ch;
                String newString = new String(arr);
                if (map.containsKey(newString) && map.get(newString) == false) {
                    ret.add(newString);
                    map.put(newString, true);
                }
            }
            arr[i] = tmp;
        }
        return ret;
    }
}
