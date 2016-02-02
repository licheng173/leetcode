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
            
            int sum = l1.val + l2.val + flag;
            if(sum >= 10){
                flag = 1;
                m.val = sum - 10;
            }
            else
            {
                flag = 0;
                m.val = sum;
                
            }
            
            if(l1.next == null && l2.next != null){
                ListNode p = new ListNode(0);
                l1.next = p;
            }
            if(l1.next != null && l2.next == null){
                ListNode q = new ListNode(0);
                l2.next = q;
            }
            l1 = l1.next;
            l2 = l2.next;
            
            first.next = m;
            first = first.next;
            
            
        }
        return head.next;
    }
}

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


