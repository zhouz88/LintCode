import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();
        int[] f = new int[len];
        //makeset;
        int i, j;
        for (i = 0; i < f.length; i++) {
            f[i] = i;
        }
        Map<String, Integer> emailIdMap = new HashMap<>();

        for (i = 0; i < accounts.size(); i++) {
            List<String> emails = accounts.get(i);
            for (j = 1; j < emails.size(); j++) {
                if (!emailIdMap.containsKey(emails.get(j))) {
                    emailIdMap.put(emails.get(j), i);
                } else { //two acount sould merge
                    int first = emailIdMap.get(emails.get(j));
                    int second = i;
                    int fa = find(first, f);
                    int fb = find(second,f);
                    if (fa != fb) {
                        f[fa] = fb;
                    }
                }
            }
        }
        List<String>[] res = new ArrayList[len];
        for (i = 0; i < len; i++) {
            res[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> e : emailIdMap.entrySet()) {
            int id = find(e.getValue(), f);
            String email = e.getKey();
            res[id].add(email);
        }
        List<List<String>> ret = new ArrayList<>();
        for (i = 0; i < len; i++) {
            if (res[i].size() == 0) continue;
            Collections.sort(res[i]);
            res[i].add(0, accounts.get(i).get(0));
            ret.add(res[i]);
        }
        return ret;
    }

    private int find(int first, int[] f) {
        if (first == f[first]) {
            return first;
        }
        return f[first] = find(f[first], f);
    }
}
