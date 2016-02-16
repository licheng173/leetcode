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
        if(inorder.length == 0 || postorder.length == 0) return null;
        int len = postorder.length;
        return build( inorder, postorder,len - 1,0, len - 1);
    }
    public TreeNode build(int[] inorder, int[] postorder,int posfirst, int infirst, int inend)
    {
        if(posfirst  < 0 || infirst > inend)  return null;
       // int i = 0;
        //System.out.println(posfirst);
        TreeNode t = new TreeNode(postorder[posfirst]);
        int index = 0;
        for(int i = infirst; i <= inend; i++)
        {
            if(inorder[i] == postorder[posfirst])
            {
                index = i;
                  break;
            }
              
        }
        t.right = build(inorder,postorder,posfirst - 1,index+1, inend);
        t.left = build(inorder,postorder, posfirst -1 - (inend - index) ,infirst,index - 1);
        return t;
    }
}