//dfs
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, s, 0, 0, '(', ')');
        return res;
    }

    private void dfs(List<String> res, String s, int start, int lastOk, char firstChar, char secondChar) {
        for (int count = 0, i = start; i < s.length(); i++) {
            if (s.charAt(i) ==  firstChar) count++;
            else if (s.charAt(i) == secondChar) count--;
            if (count < 0) {
                for (int j = lastOk; j <= i; j++) {
                    if (s.charAt(j) == secondChar && (j == lastOk || s.charAt(j - 1) != secondChar)) {
                        dfs(res, s.substring(0, j) + s.substring(j + 1), i, j, firstChar, secondChar);
                    }
                }
                return;
            }
        }
        String next = new StringBuilder(s).reverse().toString();
        if (firstChar == '(') {
            dfs(res, next, 0, 0, secondChar, firstChar);
        } else {
            res.add(next);
        }
    }
}

//bfs
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//"()())()"
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(new Node(s, 0 , 0));

        while (!q1.isEmpty()) {
            int size = q1.size();
            for (int z = 0; z < size; z++) {
                Node node = q1.poll();
                int count = 0;
                boolean flag = true;
                for (int i = node.startOk; i < node.str.length(); i++) {
                    if (node.str.charAt(i) == '(') count++;
                    else if (node.str.charAt(i) == ')') count--;
                    if (count < 0) {
                        flag = false;
                        for (int j = node.lastNeg; j <= i; j++) {
                            if (node.str.charAt(j) == ')' && (j == node.lastNeg || node.str.charAt(j - 1) != ')')) {
                                String temp = node.str.substring(0, j) + node.str.substring(j + 1);
                                q1.add(new Node(temp, i, j));
                            }
                        }
                        break;
                    }
                }
                if (flag) {
                    node.str = new StringBuilder(node.str).reverse().toString();
                    node.startOk = 0;
                    node.lastNeg = 0;
                    q2.add(node);
                }
            }
        }
        
        while (!q2.isEmpty()) {
            int size = q2.size();
            for (int z = 0; z < size; z++) {
                Node node = q2.poll();
                int count = 0;
                boolean flag = true;
                for (int i = node.startOk; i < node.str.length(); i++) {
                    if (node.str.charAt(i) == ')') count++;
                    else if (node.str.charAt(i) == '(') count--;
                    if (count < 0) {
                        flag = false;
                        for (int j = node.lastNeg; j <= i; j++) {
                            if (node.str.charAt(j) == '(' && (j == node.lastNeg || node.str.charAt(j - 1) != '(')) {
                                String temp = node.str.substring(0, j) + node.str.substring(j + 1);
                                q2.add(new Node(temp, i, j));
                            }
                        }
                        break;
                    }
                }
                if (flag) {
                    res.add(new StringBuilder(node.str).reverse().toString());
                }
            }
        }
        
        return res;
    }

    private static class Node{
        String str;
        int startOk;
        int lastNeg;
        public Node(String str, int start, int last) {
            this.str = str;
            this.startOk = start;
            this.lastNeg = last;
        }
    }
}
