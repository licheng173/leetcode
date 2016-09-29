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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, inorder.length- 1);
        
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
        if(is > ie || ps > pe) return null;
        if(is == ie) {
            TreeNode t = new TreeNode(inorder[is]);
            t.left = null;
            t.right = null;
            return t;
        }
        int sign = postorder[pe];
        int index = is;
        while(index <= ie) {
            if(inorder[index] == sign)
                break;
            index++;
        }
        TreeNode node = new TreeNode(sign);
        //System.out.println(index);
        node.left = helper(inorder, postorder, is, index - 1, ps, ps + (index - is) - 1);
        node.right = helper(inorder, postorder, index + 1, ie, pe - (ie - index), pe - 1);
        return node;
    }
}