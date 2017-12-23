/*
692. Top K Frequent Words
DescriptionHintsSubmissionsDiscussSolution

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:

Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:

Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Input words contain only lowercase letters.

Follow up:

    Try to solve it in O(n log k) time and O(n) extra space.


*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || k <= 0) {
            throw new RuntimeException();
        }
        
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String t : words) 
            map.put(t, map.getOrDefault(t, 0) + 1);
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
           public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
               return a.getValue() - b.getValue()  == 0 ? (b.getKey()).compareTo(a.getKey()): a.getValue() - b.getValue();
           } 
        });
        
        int cnt = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (cnt < k) {
                pq.add(e);
                cnt++;
            } else {
                pq.add(e);
                pq.poll();
            }
        }
        
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }
        
        return res;
    }
}
