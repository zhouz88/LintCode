import java.util.*;

class Solution {
    public List<List<Integer>> go(ListNode[] array, ListNode root) {
        Map<ListNode, Boolean> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], false);
        }
        for (int i = 0; i < array.length; i++) {
            if (!map.get(array[i])){
                Queue<ListNode> q = new LinkedList<>();
                map.put(array[i], true);
                q.add(array[i]);
                List<Integer> list = new ArrayList<>();
                while (!q.isEmpty()) {
                    ListNode node = q.poll();
                    list.add(node.val);
                    if (node.pre != null && map.containsKey(node.pre) && !map.get(node.pre)) {
                        map.put(node.pre, true);
                        q.add(node.pre);
                    }
                    if (node.next != null && map.containsKey(node.next) && !map.get(node.next)) {
                        map.put(node.next, true);
                        q.add(node.next);
                    }
                }
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node2 = new ListNode(1);
        node.next = node2;
        node2.pre = node;

        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        node3.next = node4;
        node4.pre = node3;

        node3.pre = node2;
        node2.next = node3;

        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);

        node5.next = node6;
        node6.pre = node5;

        node4.next = node5;
        node5.pre = node4;

        ListNode[] array = new ListNode[3];
        array[0] = node2;
        array[1] = node4;
        array[2] = node5;

        List<List<Integer>> res = new Solution().go(array, node);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println("end");
        }
    }

    private static class ListNode {
        int val;
        ListNode pre, next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
