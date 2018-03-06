import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private Map<Integer, ListNode> map;
    private int cap;
    private ListNode head;
    private ListNode tail;
    
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (cap == 0) {
            return -1;
        }
        
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode tmp = map.get(key);
        remove(tmp);
        add(tmp);
        return tmp.val;
    }
    
    private void remove(ListNode node) {
        ListNode pre = node.pre;
        ListNode next = node.next;
        pre.next = next;
        next.pre = pre;
        map.remove(node.key);
    }

    private void add(ListNode node) {
        ListNode lastNode = tail.pre;
        lastNode.next = node;
        node.pre = lastNode;
        tail.pre = node;
        node.next = tail;
        map.put(node.key, node);
    }

    public void put(int key, int value) {
        if (cap == 0) {
            return ;
        }
        
        if (map.containsKey(key)) {
            ListNode tmp = map.get(key);
            tmp.val = value;
            remove(tmp);
            add(tmp);
        } else {
            if (map.size() < cap) {
                ListNode tmp = new ListNode(key, value);
                add(tmp);
            } else {
                ListNode tmp = head.next;
                remove(tmp);
                add(new ListNode(key, value));
            }
        }
    }
    
    private static class ListNode {
        int val;
        int key;
        ListNode pre;
        ListNode next;

        public ListNode (int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
