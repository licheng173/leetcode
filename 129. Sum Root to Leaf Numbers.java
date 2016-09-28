public class Solution {
    public int sumNumbers(TreeNode root) {
        int s = 0;
        int[] sum = new int[1];
        helper(sum, root, s);
        return sum[0];
    }
    
    public void helper(int[] sum, TreeNode root, int s) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            sum[0] += s * 10 + root.val;
            return;
        }
        helper(sum, root.left, s * 10 + root.val);
        helper(sum, root.right, s * 10 + root.val);
    }
}