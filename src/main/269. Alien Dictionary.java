import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        StringBuilder sb =  new StringBuilder();
        Set<Character>[] graph = new HashSet[26];
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < 26; i++) graph[i] = new HashSet<>();
        buildGraphAndSet(words, graph, set);
        Map<Character, Integer> indegree = new HashMap<>();
        buildeIndegree(indegree, graph);
        Queue<Character> q = new LinkedList<>();
        for (Character ch : set) {
            // System.out.println(ch);
            if (!indegree.containsKey(ch)) {
                q.add(ch);
            }
        }
        while (!q.isEmpty()) {
            Character node = q.poll();
            sb.append(node);
            for (Character ch : graph[node - 'a']) {
               int number = indegree.get(ch);
               if (number == 1) {
                   indegree.remove(ch);
                   q.add(ch);
               } else {
                   number--;
                   indegree.put(ch, number);
               }
            }
        }
        if (sb.length() != set.size()) {
            return "";
        }
        return sb.toString();
    }

    private void buildeIndegree(Map<Character, Integer> indegree, Set<Character>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].size() != 0) {
                for (Character ch : graph[i]) {
                    indegree.put(ch, indegree.getOrDefault(ch, 0) + 1);
                }
            }
        }
    }

    private void buildGraphAndSet(String[] words, Set<Character>[] graph, Set<Character> set) {
        for (int i = 0; i < words.length - 1; i++) {
            String start = words[i];
            String end = words[i + 1];
            for (int j = 0; j < Math.min(start.length(), end.length()); j++) {
                if (start.charAt(j) != end.charAt(j)) {
                    graph[start.charAt(j) - 'a'].add(end.charAt(j));
                    break;
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                set.add(ch);
            }
        }
    }
}
