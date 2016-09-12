public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ahead = new ListNode(-1);
        ListNode current = head;
        ahead.next = head;
        ListNode pre = ahead;
        boolean f = false;
        while(current != null && current.next != null) {
            if(pre.next.val == current.next.val) {
                f = true;
               current = current.next;
            }
            else {
                if(f) {
                    current = current.next;
                    pre.next = current;
                    f = false;
                }
                else
                {
                    current = current.next;
                    pre = pre.next;
                }
            }
        }
        if(f) {
            pre.next = current.next;
        }
        return ahead.next;
    }
}

//
public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;
    
    if (head.next != null && head.val == head.next.val) {
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        return deleteDuplicates(head.next);
    } else {
        head.next = deleteDuplicates(head.next);
    }
    return head;
}

//

public ListNode deleteDuplicates(ListNode head) {
    //use two pointers, slow - track the node before the dup nodes, 
    // fast - to find the last node of dups.
    ListNode dummy = new ListNode(0), fast = head, slow = dummy;
    slow.next = fast;
    while(fast != null) {
        while (fast.next != null && fast.val == fast.next.val) {
            fast = fast.next;    //while loop to find the last node of the dups.
        }
        if (slow.next != fast) { //duplicates detected.
            slow.next = fast.next; //remove the dups.
            fast = slow.next;     //reposition the fast pointer.
        } else { //no dup, move down both pointer.
            slow = slow.next;
            fast = fast.next;
        }
        
    }
    return dummy.next;
} 