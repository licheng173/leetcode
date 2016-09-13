public class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode first = head;
        if(head == null) return;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        slow = slow.next;
        mid.next = null;
        while(slow != null) {
            ListNode tmp = slow.next;
            slow.next = mid.next;
            mid.next = slow;
            slow = tmp;
        }
        ListNode s = mid.next;
        mid.next = null;
        //System.out.println(s.val);
        while(s != null) {
            ListNode t2 = s.next;
            ListNode t3 = head.next;
            s.next = head.next;
            head.next = s;
            head = t3;
            s = t2;
        }
        head = first;
    }
}