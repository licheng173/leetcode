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

