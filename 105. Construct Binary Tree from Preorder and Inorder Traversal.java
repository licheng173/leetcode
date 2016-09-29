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

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if(ps > pe || is > ie) {
            return null;
        }
        if(is == ie) {
            TreeNode n = new TreeNode(inorder[is]);
            
            n.left = null;
            n.right = null;
            return n;
        }
        TreeNode node = new TreeNode(preorder[ps]);
        int index = is;
        while(index <= ie) {
            if(inorder[index] == preorder[ps])
                break;
            index++;
        }
        //System.out.println(index);
        node.left = helper(preorder, inorder, ps + 1, index - is + ps, is, index - 1);
        node.right = helper(preorder, inorder, pe - ie + index + 1, pe, index + 1, ie);
        return node;
        
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