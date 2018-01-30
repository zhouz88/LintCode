import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    private ListNode head;
    private ListNode tail;
    private Map<Integer, ListNode> map;
    private int cap;
    
    public LRUCache(int capacity) {
        // do intialization if necessary
        map = new HashMap<>();
        head = new ListNode(-1, 0);
        tail = new ListNode(-2, 0);
        head.next = tail;
        tail.pre = head;
        this.cap = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int ret = map.get(key).value;
        ListNode tmp = remove(key);
        add(tmp, key);
        return ret;
    }
    
    private ListNode remove(int key) {
        ListNode tmp = map.get(key);
        ListNode next = tmp.next;
        tmp.pre.next = next;
        next.pre = tmp.pre;
        tmp.pre = null;
        tmp.next = null;
        map.remove(key);
        return tmp;
    }
    
    private void add(ListNode tmp, int key) {
        tail.pre.next = tmp;
        tmp.next = tail;
        ListNode a = tail.pre;
        tail.pre = tmp;
        tmp.pre = a;
        map.put(key, tmp);
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void put(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            get(key);
            map.get(key).value = value;
        } else {
            if (map.size() < cap) {
                add(new ListNode(key, value), key);
            } else {
                int oldKey = head.next.key;
                remove(oldKey);
                add(new ListNode(key,value), key);
            }
        }
    }
    
    private static class ListNode {
        int key;
        int value;
        ListNode pre, next;
        
        public ListNode(int key, int value) { 
            this.key = key;
            this.value = value;
        }
    }
}
