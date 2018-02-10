import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        Set<Character> set = new HashSet<>();
        List<char[]> list = buildEdges(words, set);
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> ends = new HashMap<>();

        for (char[] ch : list) {
            graph.putIfAbsent(ch[0], new HashSet<>());
            if (!graph.get(ch[0]).contains(ch[1])) { //wrong 4 not duplicate should in the list
                graph.get(ch[0]).add(ch[1]);
                ends.put(ch[1], ends.getOrDefault(ch[1],0)+1);
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (Character ch: set) {
            if (!ends.containsKey(ch)) {
                q.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        
        while (!q.isEmpty()) {
            char tmp = q.poll();
            sb.append(tmp);
            if (graph.containsKey(tmp)) {
                for (char ch : graph.get(tmp)) {
                    ends.put(ch, ends.get(ch) - 1);
                    if (ends.get(ch) == 0) {
                        q.add(ch);
                        ends.remove(ch);
                    } else {
                        continue;
                    }
                }
            }
        }
        
        //System.out.println(sb.toString());
        if (set.size() == 1) {//wrong 1
            return ""+set.iterator().next();
        }

        return sb.length() == set.size() ? sb.toString() : "";//wrong 3
    }

    private List<char[]> buildEdges(String[] words, Set<Character> set) {
        List<char[]> ret = new ArrayList<>();
        int i, j;
        for (i = 0; i < words.length - 1; i++) {
            j = 0;
            while (j < Math.min(words[i].length(), words[i + 1].length())
                    && words[i].charAt(j) == words[i + 1].charAt(j)) {//wrong 1 j should be less than 
                j++;
            }
            if (j < Math.min(words[i].length(), words[i + 1].length())) {
                ret.add(new char[]{words[i].charAt(j), words[i + 1].charAt(j)});
            }
        }
        for (String k : words) {
            for (char ch : k.toCharArray()) {
                set.add(ch);
            }
        }
        return ret;
    }
}
