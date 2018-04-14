import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();

        for (int i = 0; i < allowed.size();i++) {
            map.putIfAbsent(allowed.get(i).substring(0, 2), new ArrayList<>());
            map.get(allowed.get(i).substring(0, 2)).add(allowed.get(i).charAt(2));
        }

        return dfs(bottom, map);
    }

    private boolean dfs(String bottom, Map<String, List<Character>> map) {
        if (bottom.length() == 1) {
            return true;
        }
        List<String> bottoms = new ArrayList<>();
        getString(bottoms, bottom, new StringBuilder(), map, 0);
        for (int i = 0; i < bottoms.size(); i++) {
            if (dfs(bottoms.get(i), map)) {
                return true;
            }
        }
        return false;
    }

    private void getString(List<String> bottoms, String bottom, StringBuilder stringBuilder, Map<String, List<Character>> map, int start) {
        if (start == bottom.length() - 1) {
            bottoms.add(stringBuilder.toString());
            return;
        }
        String tmp = bottom.substring(start, start + 2);
        if (map.containsKey(tmp)) {
            for (char ch : map.get(tmp)) {
                stringBuilder.append(ch);
                getString(bottoms, bottom, stringBuilder, map, start + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
}

//version 2
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();

        for (String k : allowed) {
            String cur = k.substring(0, 2);
            map.putIfAbsent(cur, new ArrayList<>());
            map.get(cur).add(k.charAt(2));
        }

        return solve(bottom, map, 0, new StringBuilder());
    }

    private boolean solve(String bottom, Map<String, List<Character>> map, int start, StringBuilder sb) {
        if (bottom.length() == 0) {
            return true;
        }

        if (start == bottom.length() - 1) {
            return solve(sb.toString(), map, 0, new StringBuilder());
        }
        String cur = bottom.substring(start, start + 2);
        if (!map.containsKey(cur)) {
            return false;
        } else {
            for (Character ch : map.get(cur)) {
                sb.append(ch);
                if (solve(bottom, map, start + 1, sb)) {
                    return true;
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}

