public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                return Integer.compare(o1.val, o2.val);
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        for (ListNode node: lists)
            if (node != null)
                pq.add(node);
            
        while (!pq.isEmpty()){
            p.next = pq.poll();
            p = p.next;
            
            if (p.next != null)
                pq.add(p.next);
        }
        return dummy.next;
    }
}
