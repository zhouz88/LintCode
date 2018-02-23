import java.util.*;

public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, List<String> dicts) {
        // write your code here
        List<List<String>> ret = new ArrayList<>();
        Set<String> dict = new HashSet<>(dicts);
        dict.add(start);
        if (!dict.contains(end)) {
            return ret;
        }

        int[] distance = new int[dict.size()];
        Arrays.fill(distance, - 1);
        String[] strs = new String[dict.size()];
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        int endString = -1, startString  = -1;
        for (String k : dict) {
            strs[idx++] = k;
            map.put(k, idx - 1);
            if (k.equals(start)) {
                distance[idx - 1] = 0;
                startString = idx - 1;
            }
            if (k.equals(end)) {
                endString = idx - 1;
            }
        }


        Queue<Integer> q = new LinkedList<>();
        q.add(startString);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int u = 0; u < size; u++) {
                int node = q.poll();
                List<Integer> list = getNeibor(map, strs[node]);
                if (list.size() == 0) continue;
                else {
                    for (int k : list) {
                        if (distance[k] == -1) {
                            distance[k] = distance[node] + 1;
                            q.add(k);
                        }
                    }
                }
            }
        }

        if (distance[endString] == -1) {
            return ret;
        }
        List<String> list = new ArrayList<>();
        list.add(strs[endString]);
        dfs(endString, distance, map, strs, list, ret);
        for (int i = 0;i < ret.size(); i++) {
            Collections.reverse(ret.get(i));
        }
        return ret;
    }

    private void dfs(int end, int[] distance, Map<String, Integer> map, String[] strs, List<String> list, List<List<String>> ret) {
        if (distance[end] == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        List<Integer> tmp = getNeibor(map, strs[end]);
        for (int k : tmp) {
            if (distance[k] == distance[end] - 1) {
                list.add(strs[k]);
                dfs(k, distance, map, strs, list, ret);
                list.remove(list.size() - 1);
            }
        }
    }

    private Map<Integer, List<Integer>> neibors = new HashMap<>();

    public List<Integer> getNeibor(Map<String, Integer> map, String start)  {
        if (neibors.containsKey(map.get(start))) {
            return neibors.get(map.get(start));
        }
        List<Integer> ret = new ArrayList<>();
        char[] t = start.toCharArray();
        for (int i = 0; i < t.length; i++) {
            char tmp = t[i];
            for (char ch = 'a' ; ch <= 'z'; ch++) {
                if (ch != tmp) {
                    t[i] = ch;
                    if (map.containsKey(new String(t))) {
                        ret.add(map.get(new String(t)));
                    }
                }
            }
            t[i] = tmp;
        }
        neibors.put(map.get(start), ret);
        return ret;
    }
}
