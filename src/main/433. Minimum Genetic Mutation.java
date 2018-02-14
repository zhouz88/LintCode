import java.util.*;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Map<String, Boolean> map = new HashMap<>();
        
        for (String k : bank) {
            map.put(k, false);
        }
        Queue<String> q = new LinkedList<>();
        Set<Character> characters = new HashSet<>();
        characters.add('A');
        characters.add('T');
        characters.add('C');
        characters.add('G');
        
        q.add(start);
        map.put(start, true);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            
            for (int a = 0; a < size; a++) {

                String node = q.poll();
                if (node.equals(end)) {
                    return step - 1;
                }
                
                char[] t = node.toCharArray();
                for (int i = 0; i < t.length; i++) {
                    char tmp = t[i];
                    for (char ch : characters) {
                        if (tmp != ch) {
                            t[i] = ch;
                            String newString = new String(t);
                            if (map.containsKey(newString) && !map.get(newString)) {
                                q.add(newString);
                                map.put(newString, true);
                            }
                        }
                    }
                    t[i] = tmp;
                }
            }
            
        }
        
        return -1;
    }
}
