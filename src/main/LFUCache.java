import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

class LFUCache {

    private Map<Integer,Integer> keyValueMap = new HashMap<>();
    private Map<Integer, Integer> keyCountMap = new HashMap<>();
    private Map<Integer, LinkedHashSet<Integer>> frequencyKeysMap = new TreeMap<>();
    private int cap;

    public LFUCache(int capacity) {
         this.cap = capacity;
    }

    public int get(int key) {
        if (!keyValueMap.containsKey(key)) {
            return -1;
        }
        int frequency = keyCountMap.get(key);
        keyCountMap.put(key, frequency + 1);
        frequencyKeysMap.get(frequency).remove(key);
        if (frequencyKeysMap.get(frequency).size() == 0) {
            frequencyKeysMap.remove(frequency);
        }
        frequencyKeysMap.putIfAbsent(frequency + 1, new LinkedHashSet<>());
        frequencyKeysMap.get(frequency + 1).add(key);
        return keyValueMap.get(key);
    }

    public void set(int key, int value) {
        if (!keyValueMap.containsKey(key)) {
            if (keyValueMap.size() < cap) {
                keyValueMap.put(key, value);
                keyCountMap.put(key, 1);
                frequencyKeysMap.putIfAbsent(1, new LinkedHashSet<>());
                frequencyKeysMap.get(1).add(key);
            } else {
                Integer minFrequency = frequencyKeysMap.keySet().iterator().next();
                Integer removingKey = frequencyKeysMap.get(minFrequency).iterator().next();
                frequencyKeysMap.get(minFrequency).remove(removingKey);
                if (frequencyKeysMap.get(minFrequency).size() == 0) {
                    frequencyKeysMap.remove(minFrequency);
                }
                keyValueMap.remove(removingKey);
                keyCountMap.remove(removingKey);
                keyValueMap.put(key, value);
                keyCountMap.put(key , 1);
                frequencyKeysMap.putIfAbsent(1, new LinkedHashSet<>());
                frequencyKeysMap.get(1).add(key);
            }
        } else {
            keyValueMap.put(key, value);
            int frequency = keyCountMap.get(key);
            keyCountMap.put(key, keyCountMap.getOrDefault(key, 0) + 1);
            frequencyKeysMap.get(frequency).remove(key);
            if (frequencyKeysMap.get(frequency).size() == 0) {
                frequencyKeysMap.remove(frequency);
            }
            frequencyKeysMap.putIfAbsent(frequency + 1, new LinkedHashSet<>());
            frequencyKeysMap.get(frequency + 1).add(key);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

class LFUCache {

    private Map<Integer,Integer> keyValueMap = new HashMap<>();
    private Map<Integer, Integer> keyCountMap = new HashMap<>();
    private Map<Integer, LinkedHashSet<Integer>> frequencyKeysMap = new HashMap<>();
    private int cap;
    private int minFrequency;

    public LFUCache(int capacity) {
         this.cap = capacity;
    }

    public int get(int key) {
        if (!keyValueMap.containsKey(key)) {
            return -1;
        }
        int frequency = keyCountMap.get(key);
        keyCountMap.put(key, frequency + 1);
        frequencyKeysMap.get(frequency).remove(key);
        if (frequencyKeysMap.get(frequency).size() == 0) {
            frequencyKeysMap.remove(frequency);
            if (frequency == minFrequency) {
                minFrequency++;
            }
        }
        frequencyKeysMap.putIfAbsent(frequency + 1, new LinkedHashSet<>());
        frequencyKeysMap.get(frequency + 1).add(key);
        return keyValueMap.get(key);
    }

    public void put(int key, int value) {
        if (!keyValueMap.containsKey(key)) {
            if (keyValueMap.size() < cap) {
                keyValueMap.put(key, value);
                keyCountMap.put(key, 1);
                frequencyKeysMap.putIfAbsent(1, new LinkedHashSet<>());
                frequencyKeysMap.get(1).add(key);
                minFrequency = 1;
            } else {
                Integer removingKey = frequencyKeysMap.get(minFrequency).iterator().next();
                frequencyKeysMap.get(minFrequency).remove(removingKey);
                if (frequencyKeysMap.get(minFrequency).size() == 0) {
                    frequencyKeysMap.remove(minFrequency);
                }
                keyValueMap.remove(removingKey);
                keyCountMap.remove(removingKey);
                keyValueMap.put(key, value);
                keyCountMap.put(key , 1);
                frequencyKeysMap.putIfAbsent(1, new LinkedHashSet<>());
                frequencyKeysMap.get(1).add(key);
                minFrequency = 1;
            }
        } else {
            keyValueMap.put(key, value);
            int frequency = keyCountMap.get(key);
            keyCountMap.put(key, keyCountMap.getOrDefault(key, 0) + 1);
            frequencyKeysMap.get(frequency).remove(key);
            if (frequencyKeysMap.get(frequency).size() == 0) {
                frequencyKeysMap.remove(frequency);
                if (frequency == minFrequency) {
                    minFrequency++;
                }
            }
            frequencyKeysMap.putIfAbsent(frequency + 1, new LinkedHashSet<>());
            frequencyKeysMap.get(frequency + 1).add(key);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
