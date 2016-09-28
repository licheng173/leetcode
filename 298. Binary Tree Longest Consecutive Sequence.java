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
    public int longestConsecutive(TreeNode root) {
        int[] max = new int[1];
        int count = 1;
        helper(max, count, root);
        return max[0];
    }
    
    public void helper(int[] max, int count, TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            max[0] = Math.max(max[0], count);
            return;
            
        }
        if(root.left != null) {
            if(root.left.val == root.val + 1) {
                max[0] = Math.max(max[0], count + 1);
                helper(max, count + 1, root.left);
            }
            else {
                helper(max, 1, root.left);
            }
        }
        if(root.right != null) {
            if(root.right.val == root.val + 1) {
                max[0] = Math.max(max[0], count + 1);
                helper(max, count + 1, root.right);
            }
            else {
                helper(max, 1, root.right);
            }
        }
    }
}


//
public class Solution {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0, root.val);
        return max;
    }
    public void helper(TreeNode root, int cur, int target){
        if(root == null) return;
        if(root.val == target) cur++;
        else cur = 1;
        max = Math.max(cur, max);
        helper(root.left, cur, root.val + 1);
        helper(root.right, cur, root.val + 1);
    }
}