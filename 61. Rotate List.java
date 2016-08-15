public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode ne = new ListNode(-1);
        ne.next = head;
        ListNode first = ne;
        ListNode second = ne;
        int count = k;
        int length = 0;
        ListNode headd = head;
        while(headd != null){
            headd = headd.next;
            length++;
        }
        count = k % length;
        if(count == 0) return head;
        while(second != null && second.next != null) {
            while(second.next != null  && count > 0) {
                second = second.next;
                count--;
            }
           
            first = first.next;
            second = second.next;
        }
        ListNode nee = first.next;
        first.next = second.next;
        second.next = head;
        return nee;
    }
}

//