
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode head = first;
        int flag = 0;
        while(l1 != null || l2 != null || flag == 1){
            
            if(l1 == null && l2 == null && flag == 1){
                ListNode n = new ListNode(0);
                n.val = 1;
                first.next = n;
                return head.next;
            }
            
            ListNode m = new ListNode(0);
            if(l1 == null && l2 != null){
                sum = 0 + l2.val + flag;
            }
            if(l1 != null && l1 == null){
                sum = 0 + l1.val +flag;
            }
            m.val = sum % 10;
            flag = sum / 10;
            first.next = m;
            first = first.next;
            if(l1 == null)
                l1 = l1;
            else 
                l1 = l1.next;
            if(l2 == null)
                l2 = l2;
            else
                l2 = l2.next;
        }
        return head.next;
    }
}


//second
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode h = new ListNode(0);
        ListNode nh = h;
        while(l1 != null || l2 != null) {
            if(l1.next == null && l2.next != null) {
                ListNode t = new ListNode(0);
                t.next = null;
                l1.next = t;
            }
            else if(l2.next == null && l1.next != null) {
                ListNode t = new ListNode(0);
                t.next = null;
                l2.next = t;
            }
            int sum = l1.val + l2.val + carry;
            int div = sum % 10;
            carry = sum / 10;
            ListNode tmp = new ListNode(div);
            h.next = tmp;
            h = h.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(carry == 1) {
            ListNode m = new ListNode(1);
            h.next = m;
        }
        return nh.next;
    }
}