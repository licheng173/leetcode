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
    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> out = new ArrayList<List<TreeNode>>();
        List<TreeNode> l1 = new ArrayList<TreeNode>();
        List<TreeNode> l0 = new ArrayList<TreeNode>();
        if(n == 0) return l0;
        l1.add(new TreeNode(1)); l0.add(null);
        out.add(l0);out.add(l1);
        for(int t = 2; t <= n; t++) {
            List<TreeNode> lt = new ArrayList<>();
            for(int i = 1; i <= t; i++) {
                int offset = t - i;
                List<TreeNode> tmp = helper(out.get(t - i), i, t - i);
                for(TreeNode left: out.get(i - 1)) {
                    for(TreeNode right: tmp) {
                        TreeNode newNode = new TreeNode(i);
                        newNode.left = left;
                        newNode.right = right;
                        lt.add(newNode);
                    }
                }
            }
            out.add(lt);
        }
        return out.get(n);
    }
    
    public List<TreeNode> helper(List<TreeNode> lt, int offset, int length) {
        List<TreeNode> l = new ArrayList<>();
        if(length == 0) return lt;
        for(TreeNode m : lt) {
            l.add(traverse(m, offset));
        }
        return l;
    }
    public TreeNode traverse(TreeNode root, int off) {
        if(root == null) {
            return root;
        }
        TreeNode newNode = new TreeNode(root.val + off);
        newNode.left = traverse(root.left, off);
        newNode.right = traverse(root.right, off);
        return newNode;
    }
}