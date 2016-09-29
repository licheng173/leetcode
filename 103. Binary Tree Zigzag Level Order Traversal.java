public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return out;
        q.add(root);
        int flag = 0;
        while(!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int size = q.size();
            flag++;
            for(int i = 0; i < size; i++) {
                TreeNode p = q.remove();
                if(flag % 2 == 0)l.add(0, p.val);
                else l.add(p.val);
                if(p.left != null) q.add(p.left);
                if(p.right != null) q.add(p.right);
            }
            out.add(l);
        }
    return out;
    }
}