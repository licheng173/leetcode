public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode newHead = new ListNode(-1);
        ListNode uh= newHead;
        newHead.next = head;
        ListNode start = head;
        while(start != null && start.next != null) {
            ListNode tmp = start.next.next;
            ListNode second = newHead.next.next;
            newHead.next = second;
            start.next = second.next;
            second.next = start;
            newHead = start;
            start = tmp;
            
        }
        return uh.next;     
    }
}