/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//67ms
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        return buildBtree(preorder, inorder,new TreeNode(preorder[0]));
    }

    public TreeNode buildBtree(int[] preorder, int[] inorder,TreeNode root)
    {
    	if(preorder.length <= 1) return root;
        int flag = 0;
        TreeNode l,r;
    	for(int i =0; i < inorder.length; i++)
    	{
    		if(inorder[i] == preorder[0])
    		{
    			flag = i;
    			break;
    		}
    	}
    	int[] leftInorder;
    	int[] leftPreorder;
    	int[] rightInorder;
    	int[] rightPreorder;
    	//System.out.println(inorder.length - flag -1);
    	if(flag != 0)
    	{
    	    leftInorder = new int[flag];
    	    leftPreorder = new int[flag];
    	    for(int i = 0; i < flag; i++)
    	    {
    	    	leftInorder[i] = inorder[i];
    	    }
    	    for(int i = 1; i <= flag; i++)
    	    {
    	    	leftPreorder[i - 1] = preorder[i];
    	    }
    	    l = new TreeNode(leftPreorder[0]);
    	    root.left = buildBtree(leftPreorder,leftInorder,l);
    	}
    	else
    	{
    	    leftInorder = new int[0];
    	    leftPreorder = new int[0];
    	    l = null;
    	    root.left = buildBtree(leftPreorder,leftInorder,l);
    	}
    	if(inorder.length - flag - 1 != 0)
    	{
    	    rightInorder = new int[inorder.length - flag -1];
    	    rightPreorder = new int[inorder.length - flag -1];
    		for(int i = flag + 1; i < inorder.length; i++)
    	    {
    		    rightInorder[i - flag - 1] = inorder[i];
    	    }
    	    for(int i = flag + 1; i < preorder.length; i++)
    	    {   
    		    rightPreorder[i - flag - 1] = preorder[i];
    	    }
    	    r = new TreeNode(rightPreorder[0]);
    	    root.right = buildBtree(rightPreorder,rightInorder,r);
    	}
        else
        {
            rightInorder = new int[0];
    	    rightPreorder = new int[0];
            r =null;
            root.right = buildBtree(rightPreorder,rightInorder,r);
        }
    	return root;
    	
    }
}
//simple version

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(0, 0, inorder.length - 1, preorder, inorder);
	}	

	public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    	if (preStart > preorder.length - 1 || inStart > inEnd) {
        	return null;
    	}
    	TreeNode root = new TreeNode(preorder[preStart]);
    	int inIndex = 0; // Index of current root in inorder
    	for (int i = inStart; i <= inEnd; i++) {
        	if (inorder[i] == root.val) {
            	inIndex = i;
        	}
    	}
    	root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
    	root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
    	return root;
	}
}