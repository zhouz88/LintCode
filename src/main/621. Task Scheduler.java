class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null) {
            return 0;
        }
        
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        
        Arrays.sort(count);
        
        int i = 25;
        int max = count[i];
        
        while (i >= 0 && count[i] == max) {
            i--;
        }
        
        return Math.max(tasks.length, (max - 1) * (n + 1) + 25 - i);
    }
}

/*
*/
import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            pq.add(new Node(e.getKey(), e.getValue(), 0));
        }
        int cnt = 0;
        List<Node>  coolingList = new ArrayList<>();
        while (!pq.isEmpty() || coolingList.size() != 0) {
            cnt++;
            if (!pq.isEmpty()) {
                Node node = pq.poll();
                updateCoolingList(coolingList, pq);
                node.val--;
                if (node.val != 0) {
                    node.cooling = n;
                    coolingList.add(node);
                }
            } else {
                updateCoolingList(coolingList, pq);
            }
        }
        return cnt;
    }

    private void updateCoolingList(List<Node> coolingList, PriorityQueue<Node> pq) {
        Iterator<Node> iterator = coolingList.iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (--node.cooling == 0) {
                pq.add(node);
                iterator.remove();
            }
        }
    }

    private static class Node implements Comparable<Node>{
        int val;
        char ch;
        int cooling;
        
        public Node(char ch, int val, int cooling) {
            this.val = val;
            this.ch = ch;
            this.cooling = cooling;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.val, this.val);
        }
    }
}
//
class Solution {
    public int leastInterval(char[] tasks, int n) {
        String S = new String(tasks);
        int[] counts = new int[26];
        int[] valid = new int[26];
        for (char ch : S.toCharArray()) {
            counts[ch - 'A']++;
        }
        int total = 0;
        //StringBuilder sb = new StringBuilder();
        for  (int i = 0, cnt = 0; cnt < S.length(); i++) {
            int j = next(counts, valid, i, n + 1);
            if (j == -1) {
                //sb.append(" ");
                total++;
            } else {
                //sb.append((char) ('A' + j));
                total++;
                cnt++;
            }
        }
        //return sb.length();
        return total;
    }

    private int next(int[] counts, int[] valid, int index, int k) {
        int maxIdx = -1;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0 && valid[i] <= index) {
                if (maxIdx == -1) maxIdx = i;
                else if (counts[i] > counts[maxIdx]) maxIdx = i;
            }
        }
        if (maxIdx == -1) return -1;
        counts[maxIdx]--;
        if (counts[maxIdx] > 0) {
            valid[maxIdx] = index + k;
        }
        return maxIdx;
    }
}
