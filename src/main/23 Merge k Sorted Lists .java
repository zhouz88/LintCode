import java.util.*;

/**
 * Definition for ListNode.

 */
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }

        Comparator<ListNode> valueComparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };

        PriorityQueue<ListNode> pq = new PriorityQueue<>(10, valueComparator);
        Map<ListNode, Integer> nodeRowMap = new HashMap<>();

        for (int i = 0; i < lists.size(); i++) {
            ListNode cur = lists.get(i);
            if (cur != null) {
                ListNode tmp = cur.next;
                cur.next = null;
                pq.add(cur);
                nodeRowMap.put(cur, i);
                lists.set(i, tmp);
            } 
        }
            
        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;
        int row;
        while (!pq.isEmpty()) {
            p.next= pq.poll();
            p = p.next;
            row = nodeRowMap.get(p);
            ListNode cur = lists.get(row);
            if (cur != null) {
                ListNode tmp = cur.next;
                cur.next = null;
                pq.add(cur);
                nodeRowMap.put(cur, row);
                lists.set(row, tmp);
            }
        }
        return dummyNode.next;
    }
}
