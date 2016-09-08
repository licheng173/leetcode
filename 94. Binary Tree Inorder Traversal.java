public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> store = new ArrayList<Integer>();
        inorder(root, store);
        return store;
    }
    public void inorder(TreeNode node, List<Integer> store)
    {
        if(node == null)
        return;
        
        inorder(node.left, store);
        store.add(node.val);
        inorder(node.right, store);
    }
}




// iteration
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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> l = new ArrayList<Integer>();
        TreeNode tr = root;
        while(!stack.empty() || tr != null) {
            while(tr != null) {
                stack.push(tr);
                tr = tr.left;
            }
            tr = stack.pop();
            l.add(tr.val);
            tr = tr.right;
        }
        return l;
    }
}