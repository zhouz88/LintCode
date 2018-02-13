import java.util.*;

class AllOne {

    private Map<String, Integer> keyCountsMap = new HashMap<>();
    private TreeMap<Integer, Set<String>> fequencyKeysMap = new TreeMap<>();

    /** Initialize your data structure here. */
    public AllOne() {

    }

    public void inc(String key) {
        keyCountsMap.put(key, keyCountsMap.getOrDefault(key, 0) + 1);
        int count = keyCountsMap.get(key);
        if (count > 1) {
            fequencyKeysMap.get(count - 1).remove(key);
            if (fequencyKeysMap.get(count - 1).size() == 0) {
                fequencyKeysMap.remove(count - 1);
            }
            fequencyKeysMap.putIfAbsent(count, new HashSet<>());
            fequencyKeysMap.get(count).add(key);
        } else {
            fequencyKeysMap.putIfAbsent(count, new HashSet<>());
            fequencyKeysMap.get(count).add(key);
        }
    }

    public void dec(String key) {
        if (!keyCountsMap.containsKey(key)) {
            return;
        }
        keyCountsMap.put(key, keyCountsMap.getOrDefault(key, 0) - 1);
        int count = keyCountsMap.get(key);
        if (count == 0) {
            keyCountsMap.remove(key);
        }
        
        fequencyKeysMap.get(count + 1).remove(key);
        if (fequencyKeysMap.get(count  +1).size() == 0) {
            fequencyKeysMap.remove(count+1);
        }
        
        if (count > 0) {
            fequencyKeysMap.putIfAbsent(count, new HashSet<>());
            fequencyKeysMap.get(count).add(key);
        }
    }

    public String getMinKey() {
        if (fequencyKeysMap.size() == 0) {
            return "";
        }
        return fequencyKeysMap.get((fequencyKeysMap.keySet().iterator().next())).iterator().next();
    }

    public String getMaxKey() {
        if (fequencyKeysMap.size()== 0) {
            return "";
        }
        return fequencyKeysMap.get((fequencyKeysMap.descendingKeySet().iterator().next())).iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
