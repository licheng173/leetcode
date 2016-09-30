public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<Integer> stack = new Stack<Integer>();
        return helper(root, stack);
    }
    
    public boolean helper(TreeNode root, Stack<Integer> stack) {
        if(root == null) return true;
        boolean left = helper(root.left, stack);
        if(!stack.isEmpty()) {
            if(stack.peek() >= root.val)
                return false;
        }
        stack.push(root.val);
        boolean right = helper(root.right, stack);
        return right && left;
    }
}
    }
}