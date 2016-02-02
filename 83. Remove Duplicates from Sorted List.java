public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preNode = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        preNode.next = head;
        ListNode s = preNode;
        while(cur != null)
        {
            if(preNode.val == cur.val) 
            {
                cur = cur.next;
            }
            else
            {
                preNode.next = cur;
                preNode = preNode.next;
                cur = cur.next;
            }
        }
        if(cur == null)
        preNode.next = cur;
        return s.next;
    }
}

//concise
public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
}