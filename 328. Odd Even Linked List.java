public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        int count = 1;
        ListNode newHead = head.next.next;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode oddTail = head;
        ListNode evenTail= head.next;
        oddTail.next = null;
        evenTail.next = null;
       
       while(newHead != null)
       {
           ListNode tmp = newHead.next;
           if(count%2 == 1)
           {
                newHead.next = null;
                oddTail.next = newHead;
                oddTail = newHead;
                count++;
           }
           else if(count%2 == 0){
               newHead.next = null;
               evenTail.next = newHead;
               evenTail = newHead;
               count++;
           }
           newHead = tmp;
        }
       oddTail.next = evenNode;
       return oddNode;
    }
}

//
public class Solution {
public ListNode oddEvenList(ListNode head) {
    if (head != null) {

        ListNode odd = head, even = head.next, evenHead = even; 

        while (even != null && even.next != null) {
            odd.next = odd.next.next; 
            even.next = even.next.next; 
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead; 
    }
    return head;
}}