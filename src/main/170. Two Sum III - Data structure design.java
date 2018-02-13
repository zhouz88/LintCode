import java.util.HashMap;
import java.util.Map;

class TwoSum {
    Map<Integer, Integer> map = new HashMap<>();

    /** Initialize your data structure here. */
    public TwoSum() {

    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (map.containsKey(value - e.getKey())) {
                if (value == 2*e.getKey() && e.getValue() >= 2) {
                    return true;
                } else if (value != 2*e.getKey() ) {
                    if (map.containsKey(value - e.getKey())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
