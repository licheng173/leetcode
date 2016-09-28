public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        if(root == null) return out;
        find(out, root);
        return out;
    }
    
    public int find(List<List<Integer>> out, TreeNode head) {
        if(head == null) {
            return 0;
        }
        int left = find(out, head.left);
        int right = find(out,  head.right);
        List<Integer> l;
        if(out.size() == Math.max(left, right)) {
             l = new ArrayList<Integer>();
             out.add(l);
            
        }
        out.get(Math.max(left, right)).add(head.val);
        return Math.max(left, right) + 1;
        
    }
}