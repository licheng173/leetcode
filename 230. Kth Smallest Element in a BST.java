public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count = 0;
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode tmp = stack.peek();
            count++;
            if(count == k) 
                break;
            root = tmp.right;
            stack.pop();
        }
        if(count != k) return 0;
        return stack.peek().val;
    }
}

public int kthSmallest(TreeNode root, int k) {
    int count = countNodes(root.left);
    if (k <= count) {
        return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
    }
    return root.val;
}
    
public int countNodes(TreeNode n) {
    if (n == null) return 0;
    return 1 + countNodes(n.left) + countNodes(n.right);
}