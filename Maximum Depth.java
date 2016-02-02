public class Solution {
    public int maxDepth(TreeNode root) {
        int i = 0;
        int j = 0;
        if(root == null) return 0;
        if(root.left != null) 
            i = maxDepth(root.left);
        if(root.right != null) 
            j = maxDepth(root.right);
        if(root.left == null || root.right == null)
            return (Math.max(i,j) + 1);
    }
}