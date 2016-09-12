/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        ListNode B,A;
        if(head == null || head.next == null) return head;
        A = head;
        B = head.next;
        while(B != null && B.next != null)
        {
            A = A.next;
            B = B.next.next;
        }
        B = A.next;
        A.next = null;
        A = head;
        ListNode p = sortList(A);
        ListNode q = sortList(B);
        return merge(p,q);
    }
    
    public ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode n = new ListNode(-1);
       // n.next = null;
        ListNode newhead = n;
        while(head1 != null && head2 != null)
        {
            if(head1.val >= head2.val) 
            {
                n.next = head2;
                head2 = head2.next;
                n.next.next = null;
                n = n.next;
            }
            else
            {
                n.next = head1;
                head1 = head1.next;
                n.next.next = null;
                n = n.next;
            }
        }
        if(head1 == null && head2 != null)
        {
            n.next = head2;
        //    return newhead;
        }
        if(head2 == null && head1 != null)
        {
            n.next = head1;
          //  return newhead;
        }
        return newhead.next;
    }
}


//use O(1)space

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode f = head.next.next;
        ListNode p = head;
        while (f != null && f.next != null) {
            p = p.next;
            f =  f.next.next;
        }
        ListNode h2 = sortList(p.next);
        p.next = null;
        return merge(sortList(head), h2);
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null && l2 != null) {
            return l2;
        }
        if(l1 != null && l2 == null) {
            return l1;
        }
        if(l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        if(l1.val > l2.val) {
            l2.next = merge(l1, l2.next);
            return l2;
        }
        return null;
    }
}
