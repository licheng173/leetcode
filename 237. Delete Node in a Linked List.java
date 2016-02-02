//complex versiion
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode cur = node;
        while(node.next != null)
        {
            cur = node;
            node.val = node.next.val;
            node = node.next;
        }
        cur.next = null;
    }
}
//simple version
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}