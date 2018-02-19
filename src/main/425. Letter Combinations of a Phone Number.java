import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    O(M + N)
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> ret = new ArrayList<>();

        if (digits == null) {
            throw new RuntimeException();
        }
         
        if (digits.length() == 0) {
            return ret;
        }// Wrong answer 1
        
        char[][] map = new char[10][];
        map[2] = "abc".toCharArray();
        map[3] = "def".toCharArray();
        map[4] = "ghi".toCharArray();
        map[5] = "jkl".toCharArray();
        map[6] = "mno".toCharArray();
        map[7] = "pqrs".toCharArray();
        map[8] = "tuv".toCharArray();
        map[9] = "wxyz".toCharArray();
        dfs(0, digits, map, new StringBuilder(), ret);
        return ret;
    }

    private void dfs(int start, String digits, char[][] map, StringBuilder stringBuilder, List<String> ret) {
        if (start == digits.length()) {
            ret.add(stringBuilder.toString());
            return;
        }
        for (char ch : map[digits.charAt(start) - '0']) {
            stringBuilder.append(ch);
            dfs(start + 1, digits, map, stringBuilder, ret);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

//BFS O(M + N)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> ret = new ArrayList<>();

        if (digits == null) {
            throw new RuntimeException();
        }

        if (digits.length() == 0) {
            return ret;
        }// Wrong answer 1

        char[][] map = new char[10][];
        map[2] = "abc".toCharArray();
        map[3] = "def".toCharArray();
        map[4] = "ghi".toCharArray();
        map[5] = "jkl".toCharArray();
        map[6] = "mno".toCharArray();
        map[7] = "pqrs".toCharArray();
        map[8] = "tuv".toCharArray();
        map[9] = "wxyz".toCharArray();
        
        Queue<String> q = new LinkedList<>();
        int step = 0;
        for (char ch : map[digits.charAt(0) - '0']) {
            q.add(""+ch);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                String node = q.poll();
                if (step < digits.length()) {
                    for (char ch : map[digits.charAt(step) - '0']) {
                        String p = node + ch;
                        q.add(p);
                    }
                } else {
                    ret.add(node);
                }
            }
        }
        return ret;
    }
}


搜索的时间复杂度：O(答案总数 * 构造每个答案的时间)
举例：Subsets问题，求所有的子集。子集个数一共 2^n，每个集合的平均长度是 O(n) 的，所以时间复杂度为 O(n * 2^n)，同理 Permutations 问题的时间复杂度为：O(n * n!)

动态规划的时间复杂度：O(状态总数 * 计算每个状态的时间复杂度)
举例：triangle，数字三角形的最短路径，状态总数约 O(n^2) 个，计算每个状态的时间复杂度为 O(1)——就是求一下 min。所以总的时间复杂度为 O(n^2)

用分治法解决二叉树问题的时间复杂度：O(二叉树节点个数 * 每个节点的计算时间)
举例：二叉树最大深度。二叉树节点个数为 N，每个节点上的计算时间为 O(1)。总的时间复杂度为 O(N)

添加评论
分享

