/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
import java.util.*;

public class TopKFrequentWords {

    public static class Map {
        public void map(String key, Document value, OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String[] s = value.content.split("\\s+");
            for (String k : s) {
                output.collect(k, 1);
            }
        }
    }

    public static class Reduce {
        int K;
        java.util.Map<String, Integer> map = new HashMap<>();
        
        public void setup(int k) {
            // initialize your data structure here
            K = k;
        }   

        public void reduce(String key, Iterator<Integer> values) {
            // Write your code here
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next();
            }
            map.put(key, sum);
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
           java.util.PriorityQueue<java.util.Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<java.util.Map.Entry<String, Integer>>(){
           public int compare(java.util.Map.Entry<String, Integer> a,java.util.Map.Entry<String, Integer> b) {
               return a.getValue() - b.getValue()  == 0 ? (b.getKey()).compareTo(a.getKey()): a.getValue() - b.getValue();
           } 
            });
            int cnt = 0;
            for (java.util.Map.Entry<String, Integer> e : map.entrySet()) {
                if (cnt < K) {
                    pq.add(e);
                    cnt++;
                } else {
                    pq.add(e);
                    pq.poll();
                }
            }
            java.util.List<java.util.Map.Entry<String, Integer>> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                java.util.Map.Entry<String, Integer> e = pq.poll();
                list.add(0, e);
            }
            for (java.util.Map.Entry<String, Integer> e : list) {
                output.collect(e.getKey(), e.getValue());
            }
        }
    }
}
