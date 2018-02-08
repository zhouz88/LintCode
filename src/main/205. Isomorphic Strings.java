import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        //cornercase
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> mapping1 = new HashMap<>();
        Map<Character, Character> mapping2 = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (mapping1.containsKey(s.charAt(i)) && mapping2.containsKey(t.charAt(i))) {
                if (mapping1.get(s.charAt(i)) != t.charAt(i) || mapping2.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                } 
            } else if (mapping1.containsKey(s.charAt(i)) || mapping2.containsKey(t.charAt(i))) {
                return false;
            } else {
                mapping1.put(s.charAt(i), t.charAt(i));
                mapping2.put(t.charAt(i), s.charAt(i));
            }
        }
        
        return true;
    }
}
