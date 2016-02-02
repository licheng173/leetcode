public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode h = head;
        StringBuilder bui1 = new StringBuilder();
        StringBuilder bui2 = new StringBuilder();
        while(h != null)
        {
            bui1.append(String.valueOf(h.val));
            h = h.next;
        }
        ListNode newList = null;
        while(head != null)
        {
            ListNode next = head.next;
            head.next = newList;
            newList = head;
            head = next;
        }
        while(newList != null)
        {
           bui2.append(String.valueOf(newList.val));
           newList = newList.next;
        }
        if(bui1.toString().equals(bui2.toString()))
        return true;
        return false;
    }
}
//faster
//genius to find the mid pointer
ListNode reverse(ListNode head) {
    ListNode prev = null;
    while(head!=null) {
        ListNode tmp = head.next;
        head.next = prev;
        prev = head;
        head = tmp;
    }
    return prev;
}

public boolean isPalindrome(ListNode head) {
    if (head==null) return true;

    //Find middle node: use slow, fast pointers.
    ListNode fast = head.next;
    ListNode mid = head;
    while(fast !=null && fast.next != null) {
        fast = fast.next.next;
        mid = mid.next;
    }

    //Reverse: mid..end
    ListNode tail = reverse(mid);

    //Compare tail to mid and start to mid.
    while (tail !=null && head != null) {
        if (tail.val != head.val) {
            return false;
        }
        tail = tail.next;
        head = head.next;
    }
    return true;
}