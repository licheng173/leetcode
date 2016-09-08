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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        TreeNode m = root;
        while(!stack.empty() || m != null) {
            while(m != null) {
                list.add(m.val);
                stack.push(m);
                m = m.left;
            }
            m = stack.pop();
            m = m.right;
        }
        return list;
    }
}

//
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        if(root==null) return pre;
        Stack<TreeNode> tovisit = new Stack<TreeNode>();
        tovisit.push(root);
        while(!tovisit.empty()) {
            TreeNode visiting = tovisit.pop();
            pre.add(visiting.val);
            if(visiting.right!=null) tovisit.push(visiting.right);
            if(visiting.left!=null) tovisit.push(visiting.left);
        }
        return pre;
    }
}