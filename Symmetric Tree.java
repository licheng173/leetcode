/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root != null)
        return tree(root.left,root.right);
        else return true;
    }
    public boolean tree(TreeNode left,TreeNode right){
         boolean f1,f2;
        if(left == null & right == null) return true;
        else if(left != null && right != null) 
        {
           f1 = tree(left.left, right.right);
           f2 = tree(left.right, right.left);
        }
        else return false;
        if(left.val == right.val) return (f1 && f2);
        else return false;
        
        
    }
}
//iteration
public class Solution{
    public boolean isSymmetric(TreeNode root){
        Stack<TreeNode> sta1 = new Stack<TreeNode>();  
        if(root == null) return true;
        if(root.left == null || root.right == null) 
        {
            if(root.left == null && root.right == null)
            return true;
            else
            return false;
        }
        sta1.push(root.left);
        sta1.push(root.right);
        while(!sta1.empty())
        {
            TreeNode s1 = sta1.pop();
            TreeNode s2 = sta1.pop();
            if(s1.val != s2.val) return false;
            if(s1.left != null && s2.right != null)
            {
                sta1.push(s1.left);
                sta1.push(s2.right);
            }
            if(s1.right != null && s2.left != null)
            {
                sta1.push(s1.right);
                sta1.push(s2.left);
            }

            if(s1.left == null && s2.right != null)
            return false;
            if(s1.left != null && s2.right == null)
            return false;
            if(s1.right == null && s2.left != null)
            return false;
            if(s1.right != null && s2.left == null)
            return false;
        }
        return true;
    }
}
//clean and beautiful version
