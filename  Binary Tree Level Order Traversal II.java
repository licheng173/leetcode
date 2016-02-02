public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            bfs.add(0,tmp);
        }
        return bfs;
       
    }
}
//DFS
public class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
            levelMaker(wrapList, root, 0);
            return wrapList;
        }

        public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
            if(root == null) return;
            if(level >= list.size()) {
                list.add(0, new LinkedList<Integer>());
            }
            levelMaker(list, root.left, level+1);
            levelMaker(list, root.right, level+1);
            list.get(list.size()-level-1).add(root.val);
        }
    }