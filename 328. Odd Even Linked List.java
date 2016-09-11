
//not in place
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode lodd = new ListNode(0);
        ListNode leven = new ListNode(0);
        ListNode odd1 = lodd;
        ListNode even1 = leven;
        int odd = 1;
        while(head != null) {
            if(odd == 1) {
                lodd.next = head;
                lodd = lodd.next;
                odd--;
            }
            else {
                leven.next = head;
                leven = leven.next;
                odd++;
            } 
            head = head.next;
        }
        leven.next = null;
        lodd.next = even1.next;
        return odd1.next;
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