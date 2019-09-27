import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num :nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return Integer.compare(o1.getValue(), o2.getValue()) == 0 ?
                        Integer.compare(o2.getKey(), o1.getKey()) : Integer.compare(o1.getValue(), o2.getValue()) ;
            }
        });
        int i  =0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (i < k) {
                pq.add(e);
            } else {
                if (pq.peek().getValue() >= e.getValue()) {
                    continue;
                } else {
                    pq.poll();
                    pq.add(e);
                }
            }
            i++;
        }
        int len = Math.min(k, pq.size());
        Integer[] res = new Integer[len];
        i = len - 1;
        while (!pq.isEmpty()) {
            res[i--] = pq.poll().getKey();
        }
        return Arrays.asList(res);
    }
}

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

	List<Integer>[] bucket = new List[nums.length + 1];
	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

	for (int n : nums) {
		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	}

	for (int key : frequencyMap.keySet()) {
		int frequency = frequencyMap.get(key);
		if (bucket[frequency] == null) {
			bucket[frequency] = new ArrayList<>();
		}
		bucket[frequency].add(key);
	}

	List<Integer> res = new ArrayList<>();

	for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
		if (bucket[pos] != null) {
			res.addAll(bucket[pos]);
		}
	}
	return res;
}
}

import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>();

        Map<String, Integer> map = new HashMap<>();
        for (String str: words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        Pair<String, Integer>[] pairs = new Pair[map.size()];
        int idx = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            pairs[idx++] = new Pair<>(e.getKey(), e.getValue());
        }
        for (int i = 0; i < pairs.length; i++) {
            if (i < k) {
                pq.add(pairs[i]);
            } else {
                if (pairs[i].compareTo(pq.peek()) > 0) {
                    pq.poll();
                    pq.add(pairs[i]);
                }
            }
        }
        while (!pq.isEmpty()) {
            res.add(pq.poll().key);
        }
        Collections.reverse(res);
        return res;
    }

    private static final class Pair<K extends Comparable<K>,V extends Comparable<V>> implements Comparable<Pair<K, V>>{
        V value;
        K key;

        public Pair(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public int compareTo(Pair<K, V> o) {
            return o.value.compareTo(this.value) == 0 ?
                    o.key.compareTo(this.key)
                    : this.value.compareTo(o.value);
        }
    }
}
