public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null|| q == null)
        {
            if(p == null && q == null) 
                return true;
            return false;
        }
        return tree(p,q);
    }
    public boolean tree(TreeNode p, TreeNode q)
    {
        boolean i,j;
        if(p == null && q == null) return true;
        else if(p != null && q != null) 
        {
            i = tree(p.left,q.left);
            j = tree(p.right, q.right);
        }
        else
        return false;
        if(p.val == q.val) return (i && j);
        else return false;
    }
}

//
public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) return true;
    if(p == null || q == null) return false;
    if(p.val == q.val)
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    return false;
}