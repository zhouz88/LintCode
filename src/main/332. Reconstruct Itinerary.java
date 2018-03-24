import java.util.*;

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
       Map<String, PriorityQueue<String>> map = new HashMap<>();

       for (String[] t: tickets)
           map.computeIfAbsent(t[0], k -> new PriorityQueue<>()).add(t[1]);

       dfs(res, map, "JFK");
       Collections.reverse(res);
       return res;
    }

    private void dfs(List<String> res, Map<String, PriorityQueue<String>> map, String start) {
        while (map.containsKey(start) && !map.get(start).isEmpty()) {
            dfs(res, map, map.get(start).poll());
        }
        res.add(start);
    }
}
