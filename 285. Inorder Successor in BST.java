public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right != null) return findMin(p.right);
        TreeNode parent = findParent(root, p);
        while(parent != null && parent.right == p) {
            p = parent;
            parent = findParent(root, p);
        }
        return parent;
    }
    public TreeNode findMin(TreeNode root) {
        if(root.left == null) 
            return root;
        return findMin(root.left);
    }
    
    public TreeNode findParent(TreeNode root, TreeNode node) {
        if(root.left == node || root.right == node)
            return root;
        if(node.val > root.val) return findParent(root.right, node);
        if(node.val < root.val) return findParent(root.left, node);
        return null;
    }
}


//concise solution

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }
}

//precossor
public TreeNode predecessor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val >= p.val) {
    return predecessor(root.left, p);
  } else {
    TreeNode right = predecessor(root.right, p);
    return (right != null) ? right : root;
  }
}