public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        if(root.left != null) {
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            
            while(root.right != null) {
                root = root.right;
            }
            root.right = right;
        }
        
    }
}


private TreeNode prev = null;

public void flatten(TreeNode root) {
    if (root == null)
        return;
    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
}