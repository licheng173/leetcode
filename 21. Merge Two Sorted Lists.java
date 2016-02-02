public class Solution {

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) return l2;
    if(l2 == null) return l1;

    if(l1.val < l2.val){
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }else{
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }

}
//
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode head = newHead;
        while(l1 != null && l2 != null)
        {
           ListNode next1 = l1.next;
           ListNode next2 = l2.next;
            if(l1.val < l2.val)
            {
                newHead.next = l1;
                l1.next = null;
                newHead = l1;
                l1 = next1;
            }
           else if(l1.val >= l2.val)
            {
                newHead.next = l2;
                l2.next = null;
                newHead = l2;
                l2 = next2;
            }
        }
        if(l1 == null)
        newHead.next = l2;
        if(l2 == null)
        newHead.next = l1;
        return head.next;
            
    }
}