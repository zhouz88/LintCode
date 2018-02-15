import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String k : strings) {
            String start = getFirst(k);
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(k);
        }
        return new ArrayList<>(map.values());
    }

    private String getFirst(String input) {
        StringBuilder sb = new StringBuilder();
        int k = input.charAt(0) - 'a';
        for (char ch : input.toCharArray()) {
            sb.append(getMove(ch, k));
        }
        return sb.toString();
    }
    
    private char getMove(char ch, int k) {
        return (char)(((26 + ch - 'a' - k) % 26) + 'a');
    }
}
