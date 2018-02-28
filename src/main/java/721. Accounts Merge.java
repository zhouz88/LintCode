import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<Set<String>>> map = new HashMap<>();
        for (List<String> list : accounts) {
            map.putIfAbsent(list.get(0), new ArrayList<>());
            Set<String> setlist= new HashSet<>();
            for (int i = 1; i < list.size(); i++) {
                setlist.add(list.get(i));
            }
            map.get(list.get(0)).add(setlist);
        }
        for (Map.Entry<String, List<Set<String>>> e : map.entrySet()) {
            String name = e.getKey();
            int[] f = new int[e.getValue().size()];
            for (int i = 0; i < f.length; i++) {
                f[i] = i;
            }
            List<Set<String>> tmp = e.getValue();
            for (int i = 0; i < tmp.size(); i++) {
                for (int j = i + 1; j < tmp.size(); j++) {
                    if (common(tmp.get(i), tmp.get(j))) {
                        int fa = find(f, i);
                        int fb = find(f, j);
                        if (fa != fb) {
                            f[fa] = fb;
                        }
                    }
                }
            }
            Map<Integer, Set<String>> nMap = new HashMap<>();
            
            for (int z = 0; z < tmp.size(); z++) {
                int fa = find(f, z);
                nMap.putIfAbsent(fa, new HashSet<>());
                nMap.get(fa).addAll(tmp.get(z));
            }
            
            List<List<String>> tmpList = new ArrayList<>();
            for (int k : nMap.keySet()) {
                tmpList.add(new ArrayList<>(nMap.get(k)));
                Collections.sort(tmpList.get(tmpList.size() - 1));
            }
            
            for (List<String> k : tmpList) {
                k.add(0, name);
                res.add(k);
            }
        }

        return res;
    }

    private int find(int[] f, int i) {
        if (f[i] == i) {
            return i;
        }
        return f[i] = find(f, f[i]);
    }

    private boolean common(Set<String> strings, Set<String> strings1) {
        for (String K : strings) {
            if (strings1.contains(K)) {
                return true;
            }
        }
        return false;
    }
}
