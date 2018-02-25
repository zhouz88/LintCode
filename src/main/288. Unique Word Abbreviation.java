import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ValidWordAbbr {
    Map<String, Set<String>> map = new HashMap<>();
    
    public ValidWordAbbr(String[] dictionary) {
       for (String k : dictionary) {
           String f = brif(k);
           map.putIfAbsent(f, new HashSet<>());
           map.get(f).add(k);
       }
    }

    public boolean isUnique(String word) {
        String b = brif(word);
        if (!map.containsKey(b)) {
            return true;
        } else {
            return map.get(b).size() == 1 && map.get(b).contains(word);
        }
    }

    private String brif(String s) {
        if (s.length() < 3) {
            return s;
        }
        char[] t = s.toCharArray();
        return String.valueOf(t, 0, 1) + (t.length - 2) + String.valueOf(t, t.length - 1, 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
