/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//
public class Solution {
    public ListNode plusOne(ListNode head) {
        if(recursive(head) == 1) {
            ListNode o = new ListNode(1);
            o.next = head;
            return o;
        }
        return head;
    }
    
    public int recursive(ListNode head) {
        if(head == null) {
            return 1;
        }
        int i = recursive(head.next);
        if(i == 0) {
            return 0;
        }
        int val = head.val + 1;
        head.val = val % 10;
        return val / 10;
    }
}
//66666
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;
        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        if (j.val != 9) {
            j.val++;
        } else {
            i.val++;
            i = i.next;
            while (i != null) {
                i.val = 0;
                i = i.next;
            }
        }
        
        if (dummy.val == 0) {
            return dummy.next;
        }
        
        return dummy;
    }
}
