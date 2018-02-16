import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        
         HashSet<String> set = new HashSet<>(); 
         
         for (String[] k : pairs) {
             set.add(k[0] + " "+ k[1]);
             set.add(k[1] + " "+ k[0]);
         }
         
         for (int i = 0; i < words1.length; i++) {
             if (words1[i].equals(words2[i])) {
                 continue;
             }
             String k = words1[i] + " " + words2[i];
             String p = words2[i] + " " + words1[i];
             if (!set.contains(k) && !set.contains(p)) {
                 return false;
             }
         }
         
         return true;
         
    }
}
