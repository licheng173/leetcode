public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preNode = new ListNode(0);
        preNode.next = head;
        ListNode st = preNode;
        ListNode cur = head;
        while(cur != null)
        {
            if(cur.val == val)
            {
                ListNode tmp = cur.next;
                preNode.next = tmp;
                cur = tmp;
                continue;
            }
            preNode = preNode.next;
            cur = cur.next;
        }
       return st.next;
    }
}
//recursion

public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
}
