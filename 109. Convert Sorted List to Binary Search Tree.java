public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode tree = recur(head, null);
        return tree;
    }
    
    public TreeNode recur(ListNode start, ListNode end) {
        if(start == end) return null;
        ListNode slow = start;
        ListNode fast = start;
        
        while(fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode head = new TreeNode(slow.val);
        head.left = recur(start, slow); 
        head.right = recur(slow.next, end);
        return head;
    }
}