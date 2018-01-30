import java.util.HashMap;
import java.util.Map;

class LRUCache {
class ListNode{
    int key;
    int val;
    ListNode pre;
    ListNode next;
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

    Map<Integer, ListNode> map = new HashMap<>();
    ListNode head;
    ListNode tail;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            ListNode tmp = map.get(key);
            tmp.val = value;
            remove(tmp);
            addEnd(tmp);
        } else {
            if (map.size() < cap) {
                addEnd(new ListNode(key, value));
            } else {
                remove(head);
                addEnd(new ListNode(key, value));
            }
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        ListNode tmp = map.get(key);
        remove(tmp);
        addEnd(tmp);
        return tmp.val;
    }

    public void remove(ListNode p) {
        map.remove(p.key);
        if (head == p && p == tail) {
            head = null;
            tail = null;
        } else if (p == head) {
            head = head.next;
            p.next = null;
        } else if (tail == p) {
            tail = tail.pre;
            p.next = null;
        } else {
            p.pre.next = p.next;
            p.next.pre = p.pre;
        }
    }

    public void addEnd(ListNode p) {
        map.put(p.key, p);
        if (head != null && tail != null) {
            tail.next = p;
            p.pre = tail;
            tail = p;
        } else if (head == null && tail == null) {
            head = p;
            tail = p;
        }
    }
}
