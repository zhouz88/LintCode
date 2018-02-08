import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    private ListNode head;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        random = new Random(); //wrong 1
    }

    /** Returns a random node's value. */
    public int getRandom() {
        if (head == null) {
            return -1;
        }
        int cnt = 0;
        int val = -1;
        ListNode tmp = head;
        while (tmp != null) {
            cnt++;
            if (random.nextInt(cnt) == 0) {
                val = tmp.val;
            }
            tmp = tmp.next;
        }
        return val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
