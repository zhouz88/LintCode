import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        //1 get edges;

        //2 build adjList and set of characters and indegrees table

        //3 do bfs;

        //4, return result;
        List<char[]> edges = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        buildEdges(edges, words);
        buildSet(set, words);
        
        List<Character>[] adjList = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            adjList[i] = new ArrayList<>();
        }
        int[] indegrees = new int[26];
        for (char[] e : edges) {
            adjList[e[0] - 'a'].add(e[1]);
            indegrees[e[1] - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (set.contains((char)(i+'a')) && indegrees[i] == 0) {
                q.add((char)(i+'a'));
            }
        }
        while (!q.isEmpty()) {
            Character node = q.poll();
            sb.append(node);
            for (int z = 0; z < adjList[node - 'a'].size(); z++) {
                Character next = adjList[node - 'a'].get(z);
                if (indegrees[next - 'a'] > 1) {
                    indegrees[next - 'a']--;
                } else if (indegrees[next - 'a'] == 1) {
                    indegrees[next - 'a']--;
                    q.add(next);
                }
            }
        }
        return sb.toString().length() == set.size() ? sb.toString() : "";
    }

    private void buildSet(Set<Character> set, String[] words) {
        for (String k : words) {
            for (char ch : k.toCharArray()) {
                set.add(ch);
            }
        }
    }

    private void buildEdges(List<char[]> edges, String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            String start = words[i];
            String second = words[i + 1];
            for (int l=0, r=0; l<start.length()&&r<second.length();) {
                if (start.charAt(l) == second.charAt(r)) {
                    l++;
                    r++;
                }else{
                    edges.add(new char[]{start.charAt(l), second.charAt(r)});
                    break;
                }
            }
        }
    }
}
