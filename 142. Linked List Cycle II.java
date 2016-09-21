public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode start = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                while(start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}