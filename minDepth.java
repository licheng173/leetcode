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
    public int minDepth(TreeNode root) {
        Stack<TreeNode> tree = new Stack<TreeNode>();
        if(root == null) return 0;
        root.val = 1;
        tree.push(root);
        int min = Integer.MAX_VALUE;
        while(!tree.empty())
        {
            TreeNode tmp = tree.pop();
            if(tmp.left == null && tmp.right == null)
            {
                if(tmp.val < min)
                    min = tmp.val;
            }
            if(tmp.left != null)
            {
                tmp.left.val = tmp.val + 1;
                tree.push(tmp.left);
                
            }
            if(tmp.right != null)
            {
                tmp.right.val = tmp.val + 1;
                tree.push(tmp.right);
            }
        }
        return min;
    }
}
//BFS
public int minDepth(TreeNode root) {
    if (root == null){
        return 0;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    int depth = 1;
    while (!queue.isEmpty()){
        int size = queue.size(); // determine the loop size
        for (int i = 0; i< size; i++){
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null){
                return depth;
            }
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        depth ++;
    }
    return depth;
}
//recursion
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }
}