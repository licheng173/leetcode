public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode first = head;
        ListNode second = head;
        while(second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
            if(first == second) return true;
        }
        return false;
    }
}