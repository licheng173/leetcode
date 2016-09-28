//BFS

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return list;
        q.add(root);
        while(!q.isEmpty()) {
            list.add(q.peek().val);
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode t = q.remove();
                //System.out.println(t.val + "fdf");
                if(t.right != null) q.add(t.right);
                if(t.left != null) q.add(t.left);
                
            }
        }
        return list;
    }
}

//DFS
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}