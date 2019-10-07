/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node p = head;
        while (p != null) {
            Node temp = p.next;
            p.next = new Node(p.val, temp, null);
            p = temp;
        }
        p = head;
        while (p != null) {
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }
        Node dummy = new Node(0, null, null);
        Node dummy1 = new Node(0, null, null);
        p = head;
        Node pointer1 = dummy1;
        Node pointer = dummy;
        while (p != null) {
            pointer.next = p;
            pointer1.next = p.next;
            p = p.next.next;
            pointer = pointer.next;
            pointer1 = pointer1.next;
            pointer.next = null;
            pointer1.next = null;
        }
        return dummy1.next;
    }
}
