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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> l = new ArrayList<Integer>();
        List<List<Integer>> s = new ArrayList<List<Integer>>();
        if(root == null) return s;
         path(l,s,sum,root);
         return s;
    }
    
    public void path(List<Integer> l, List<List<Integer>> s, int sum, TreeNode root){
    	if(root == null) return;
    	List<Integer> tmp = new ArrayList<Integer>(l);
    	tmp.add(root.val);
    	if(sum == root.val && root.left == null && root.right == null)
    	{
    		s.add(tmp);
    		return;
    	}
    	path(tmp,s,sum - root.val, root.left);
    	path(tmp,s,sum -root.val, root.right); 
    }
}