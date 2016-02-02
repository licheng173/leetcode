//in place
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode cur = head;
        ListNode nex = head.next;
        while(head.next != null)
        {
            head.next = nex.next;
            nex.next = cur;
            cur = nex;
            nex = head.next;
        }
        return cur;
        
    }
}
//create new list
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newList = null;
        while(head != null)
        {
            ListNode next = head.next;
            head.next = newList;
            newList = head;
            head = next;
        }
    }
    return newList;
}

//iteration
public ListNode reverseList(ListNode head) {
    return reverseListInt(head, null);
}

public ListNode reverseListInt(ListNode head, ListNode newHead) {
    if(head == null)
        return newHead;
    ListNode next = head.next;
    head.next = newHead;
    return reverseListInt(next, head);
}