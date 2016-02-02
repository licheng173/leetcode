public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> bfs = new ArrayList<List<Integer>>();
        if(root == null) return bfs;
        Queue<TreeNode> qu = new ArrayDeque<TreeNode>();
        qu.add(root);
        while(!qu.isEmpty())
        {
            List<Integer> tmp = new ArrayList<Integer>();
            int k = qu.size();
            for(int i = 0; i < k; i++)
            {
                TreeNode q = qu.poll();
                if(q.left != null)  qu.add(q.left);
                if(q.right != null) qu.add(q.right);
                tmp.add(q.val);
            }
            bfs.add(tmp);
        }
        return bfs;
    }
}

/