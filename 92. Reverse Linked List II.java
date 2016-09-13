public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        ListNode newNode = new ListNode(-1);
        ListNode current = newNode;
        newNode.next = head;
        int start = (m > n) ? n : m;
        int end = (m > n) ? m : n;
        end = end - start + 1;
        int count = 1;
        while(start - 1 > 0) {
            current = current.next;
            start--;
        }
        ListNode posCurrent = current.next;
        ListNode tail = posCurrent;
        current.next = null;
        while(posCurrent != null && count <= end) {
            ListNode tmp = posCurrent.next;
            //current.next.next = tmp;
            
            posCurrent.next = current.next;
            current.next = posCurrent;
            count++;
            posCurrent = tmp;
            
        }
        if(tail != null)
        {
            tail.next = posCurrent;
            
        }
        return newNode.next;
    }
}