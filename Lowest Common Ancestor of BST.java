public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((p.val >= root.val &&  root.val >= q.val) ||( root.val >= p.val && q.val >= root.val))
            return root;
        else if(p.val > root.val && q.val > root.val) 
            return lowestCommonAncestor(root.right,p,q);
        else 
            return lowestCommonAncestor(root.left,p,q);
    }
}