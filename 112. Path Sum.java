public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(hasSum(root, sum))
        return true;
        else
        return false;
    }
    public static boolean hasSum(TreeNode node, int sum)
        {
            boolean k= false;
            boolean j = false;;
            if(node == null) return false;
            if(node.left == null && node.right == null && node.val == sum) return true;
            j = hasSum(node.left, sum - node.val);
            k = hasSum(node.right,sum - node.val);
            return j||k;
            
        }
}