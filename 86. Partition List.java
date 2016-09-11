/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        ListNode end = list2;
        ListNode start = list1;
        while(head != null) {
            ListNode tmp = head.next;
            if(head.val >= x) {
                list2.next = head;
                list2 = list2.next;
                list2.next = null;
            }
            else {
                list1.next = head;
                list1 = list1.next;
                list1.next = null;
            }
            head = tmp;
        }
        list1.next = end.next;
        return start.next;
    }
}