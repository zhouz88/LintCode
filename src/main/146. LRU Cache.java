import java.util.HashMap;

class LRUCache {
    
    HashMap<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int cap;
    
    public LRUCache(int capacity) {
       this.cap = capacity;
       this.head = new ListNode(-1, 0);
       this.tail = new ListNode(-1, 0);
       map = new HashMap<>();
       head.next = tail;
       tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode tmp = remove(key, map);
        add(tmp, map);
        return tmp.val;
    }

    public void put(int key, int value) {
        if (cap == 0) {
            return;
        }
        
        if (map.containsKey(key)) {
            get(key);
            map.get(key).val = value;
        } else {
            if (map.size() < cap) {
                add(new ListNode(key, value), map);
            } else {
                ListNode tmp = head.next;
                tmp = remove(tmp.key, map);
                tmp.key = key;
                tmp.val = value;
                add(tmp, map);
            }
        }
    }
    
    private ListNode remove(int key, HashMap<Integer, ListNode> map) {
        ListNode tmp = map.get(key);
        map.remove(key);
        ListNode pre = tmp.pre;
        ListNode next = tmp.next;
        pre.next = next;
        next.pre = pre;
        tmp.next = null;
        tmp.pre = null;
        return tmp;
    }
    
    private void add(ListNode tmp,  HashMap<Integer, ListNode> map) {
        int key = tmp.key;
        ListNode beforetail = tail.pre;
        beforetail.next = tmp;
        tmp.pre = beforetail;
        tmp.next = tail;
        tail.pre = tmp;
        map.put(key , tmp);
    }
    
    private static class ListNode{
        int val;
        int key;
        ListNode next, pre;

        public ListNode (int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
