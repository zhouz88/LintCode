//358. Rearrange String k Distance Apartimport java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public String rearrangeString(String s, int k) {
        if (k <= 1) { //bug 1
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int[] map = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            if (map[i] == 0) continue;
            pq.add(new Node((char)(i + 'a'), map[i], 0));
        }
        
        List<Node> coolingList = new ArrayList<>();
        while (!pq.isEmpty() || !coolingList.isEmpty()) {
            if (!pq.isEmpty()) {
                Node tmp = pq.poll();
                tmp.val --;
                sb.append(tmp.ch);
                tmp.cooling = k - 1;
                updateCoolingList(coolingList, pq);
                if (tmp.val > 0) {
                    coolingList.add(tmp);
                }
            } else {
                return "";
            }
        }
        return sb.toString();
    }

    private void updateCoolingList(List<Node> coolingList, PriorityQueue<Node> pq) {
        for (int i = 0; i < coolingList.size();) {
            if (coolingList.get(i).cooling == 1) {
                pq.add(coolingList.get(i));
                coolingList.remove(i);
            } else {
                coolingList.get(i).cooling--;
                i++;
            }
        }
    }

    private static class Node implements Comparable<Node>{
        int val;
        char ch;
        int cooling;
        public Node(char ch, int val, int cooling) {
            this.ch = ch;
            this.val = val;
            this.cooling = cooling;
        }

        @Override
        public int compareTo(Node o) {
            return o.val - this.val;
        }
    }
