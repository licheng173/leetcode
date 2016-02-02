public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode cur = head;
        int t = n;
        if(head.next == null)
        return null;
        while(cur != null){
            cur = cur.next;
            if(t == 0){
                tmp = tmp.next;
                t++;
            }
            t--;
        }
        if(tmp.next == head)
        return tmp.next.next;
        ListNode p = tmp.next.next;
        tmp.next = p;
        return head;
        
    }
}