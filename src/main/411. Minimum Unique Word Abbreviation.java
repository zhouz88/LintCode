import java.util.*;

class Solution {
    public String minAbbreviation(String target, String[] dictionary) {
        if (dictionary == null || dictionary.length == 0) {
            return target.length()+"";
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        backtrack(target, pq, 0, "", 0);
    
        List<Integer> dicts = new ArrayList<>();
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].length() == target.length()) {
                dicts.add(getInteger(dictionary[i], target));
            }
        }
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            boolean flag = false;
            for (int i = 0; i < dicts.size();i++) {
                if ((node.abbr & dicts.get(i)) == node.abbr) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return node.val;
            }
        }
        return "";
    }

    private Integer getInteger(String s, String target) {
        int sum = 0;
        for (int i = 0; i < target.length(); i++) {
            if (s.charAt(i) == target.charAt(i)) {
                sum += (1 << (target.length() - 1 - i));
            }
        }
        return sum;
    }

    private static class Node implements Comparable<Node>{
        String val;
        int abbr;
        public Node(String a, int b) {
            val = a;
            abbr = b;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(val.length(), o.val.length());
        }
    }

    public void backtrack(String word, PriorityQueue<Node> pq, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0) {
                cur = cur + count;
            }
            put(pq, cur, word.length());
        } else {
            backtrack(word, pq, pos + 1, cur, count + 1);
            backtrack(word, pq, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
        }
    }

    private void put(PriorityQueue<Node> pq, String cur, int t) {
        int res = (1 << t) - 1;
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (Character.isDigit(cur.charAt(i))) {
                int tmp = cur.charAt(i) - '0';
                while (i + 1 < cur.length() && Character.isDigit(cur.charAt(i + 1))) {
                    tmp = tmp * 10 + cur.charAt(++i) - '0';
                }
                for (int j = 0; j < tmp; j++) {
                    res -= (1 << (t - 1 - cnt - j));
                }
                cnt += tmp;
            } else {
                cnt++;
            }
        }
        // System.out.println(cur + ":" + res);
        pq.add(new Node(cur, res));
    }
}
