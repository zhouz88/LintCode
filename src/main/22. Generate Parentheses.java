import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        //corner case.....
        if (n == 0) {
            return ret;
        }
        update(ret, n, new char[2*n], 0, 0); //char 数组默认长度为1 '\u0000'就和 int[] 默认 0一样
        
        return ret;
    }

    private void update(List<String> ret, int n, char[] s, int l, int r) {
        if (l > n) {
            return;  //leaf out
        }
        if (l == n && r == n) {
            System.out.println(l);
            ret.add(new String(s));
            return;
        }
        if (l > r) {  
            s[l + r] = '(';
            update(ret, n, s, l + 1, r);
            
            s[l + r] = ')';
            update(ret, n, s, l, r + 1);
        } else if (l == r) {
            s[l + r] = '(';
            update(ret, n, s, l + 1, r);
        }
    }
}

//
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] t = new char[2 * n];
        dfs(res, t, 0, 0);
        return res;
    }

    private void dfs(List<String> res, char[] t, int cntL, int cntR) {
        if (cntL + cntR == t.length) {
            res.add(new String(t));
            return;
        }
        if (cntL < t.length/2) {
            t[cntL + cntR] = '(';
            dfs(res, t, cntL + 1, cntR);
        }
        if (cntR < cntL) {
            t[cntL + cntR] = ')';
            dfs(res, t, cntL, cntR + 1);
        }
    }
}

//bfs
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        LinkedList<String> q = new LinkedList<>();
        LinkedList<Integer> leftNubmer = new LinkedList<>();
        q.add("(");
        leftNubmer.add(1);
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int z = 0; z < size; z++) {
                String node = q.poll();
                int left = leftNubmer.poll();
                if (left >= node.length() - left && left < n) {
                    q.add(node + "(");
                    leftNubmer.add(left + 1);
                }
                if (left > node.length() - left) {
                    q.add(node + ")");
                    leftNubmer.add(left);
                }
            }
            step++;
            if (step == 2 * n) break;
        }
        return q;
    }
}
