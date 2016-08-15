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
    public boolean isBalanced(TreeNode root) {
        //int[] m = new int[2];
       
        return  isBalanc(root) != -1;
    }
    
    public int isBalanc(TreeNode root) {
        if(root == null)
        return 0;
        int left = isBalanc(root.left);
        int right = isBalanc(root.right);
        //System.out.println("left" + left);
        //System.out.println("right"+ right);
        if(left == -1 || right == -1)
        return -1;
        if(left - right <=1 && left - right >= -1){
            return left>right ? left+1: right +1;
        }
        else
        return -1;
        
        
    }
}