public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return path(root, sum);
    }
    public boolean path(TreeNode root, int sum){
        if(root == null) return false; 
        if(sum == root.val && root.left == null && root.right == null)
        return true;
        boolean left = path(root.left, sum - root.val);
        boolean right = path(root.right, sum - root.val);
        return left || right;
    }
}