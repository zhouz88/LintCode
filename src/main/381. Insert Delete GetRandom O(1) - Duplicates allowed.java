import java.util.*;

class RandomizedCollection {
    private Map<Integer, Set<Integer>> map = new HashMap<>();
    private List<Integer> list = new ArrayList<>();
    private Random r = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            list.add(val);
            map.computeIfAbsent(val, k -> new HashSet<>()).add(list.size() - 1);
            return false;
        } else {
            list.add(val);
            map.computeIfAbsent(val, k -> new HashSet<>()).add(list.size() - 1);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int idx = map.get(val).iterator().next();
            map.get(val).remove(idx);
            if (idx == list.size() - 1) {
                list.remove(list.size() - 1);
                if (map.get(val).size() == 0) {
                    map.remove(val);
                }
            } else {
                int swapVal = list.get(list.size() - 1);
                map.get(swapVal).remove(list.size() - 1);
                map.get(swapVal).add(idx);
                list.remove(list.size() - 1);
                list.set(idx, swapVal);
                if (map.get(val).size() == 0) {
                    map.remove(val);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
