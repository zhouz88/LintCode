import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            if (!map.containsKey(i + 1)) {
                TreeNode root = new TreeNode(i + 1);
                map.put(i + 1, root);
                Queue<TreeNode> q = new ArrayDeque<>();
                q.add(root);
                while (!q.isEmpty()) {
                        TreeNode node = q.poll();
                    if (map.containsKey(indexes[node.val - 1][0])) {
                        node.left = map.get(indexes[node.val - 1][0]);
                    } else {
                        if (indexes[node.val - 1][0] != -1) {
                            node.left = new TreeNode(indexes[node.val - 1][0]);
                            q.add(node.left);
                            map.put(indexes[node.val - 1][0], node.left);
                        }
                    }
                    if (map.containsKey(indexes[node.val - 1][1])) {
                        node.right = map.get(indexes[node.val][1]);
                    } else {
                        if (indexes[node.val - 1][1] != -1) {
                            node.right = new TreeNode(indexes[node.val - 1][1]);
                            q.add(node.right);
                            map.put(indexes[node.val - 1][1], node.right);
                        }
                    }
                }
            }
        }
        TreeNode root = map.get(1);
        int[][] res = new int[queries.length][];
        for (int idx = 0; idx < queries.length; idx++) {
            res[idx] = bfs(root, queries[idx], indexes.length);
        }
        return res;
    }

    private static int[] bfs (TreeNode root, int k, int n) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int z = 0; z < size; z++) {
                TreeNode node = q.poll();
                if (level % k == 0) {
                    TreeNode temp = node.right;
                    node.right = node.left;
                    node.left = temp;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++;
        }
        int[] res = new int[n];
        Stack<TreeNode> stk = new Stack<>();
        TreeNode p = root;
        int idx = 0;
        while (p != null || !stk.isEmpty()) {
            if (p != null) {
                stk.add(p);
                p = p.left;
            } else {
                p = stk.pop();
                res[idx++] = p.val;
                p = p.right;
            }
        }
        return res;
    }

    private static int idx = 0;

    private static void inorder(TreeNode root, int[] res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res[idx++] = root.val;
        inorder(root.right, res);
    }

    private static final class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
