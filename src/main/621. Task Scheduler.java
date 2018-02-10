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
