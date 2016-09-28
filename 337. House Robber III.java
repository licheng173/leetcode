//tle
public class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;    
        return Math.max(helper(root), helper(root.left) + helper(root.right));
    }
    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int r1 = 0, l1 = 0;
        TreeNode l = root;
        TreeNode r = root;
        while(l.left != null)
        {
            l1 = Math.max(helper(l.left.left) + helper(l.left.right), l1);
            l = l.left;
            //System.out.println(l1);
        }
        
        while(r.right != null) {
            r1 = Math.max(helper(r.right.left) + helper(r.right.right), r1);
            r = r.right;
        }
        return Math.max(root.val + r1 + l1, helper(root.right) + helper(root.left));
    }
}



//reference 
https://discuss.leetcode.com/topic/39834/step-by-step-tackling-of-the-problem