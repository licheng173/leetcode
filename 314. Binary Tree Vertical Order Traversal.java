/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        ArrayList<List<Integer>> out = new ArrayList<List<Integer>>();
        if(root == null) return out;
        Map<Integer, List<Integer>> m = new HashMap<>();
        node.add(root);
        col.add(1);
        int min = 1;
        int max = 1;
        while(!node.isEmpty()) {
            TreeNode t = node.remove();
            int co = col.remove();
            if(!m.containsKey(co)) {
                List<Integer> l = new ArrayList<>();
                m.put(co, l);
            }
            m.get(co).add(t.val);
            if(t.left != null) {
                node.add(t.left);
                col.add(co - 1);
                if(co <= min) {
                min = co - 1;}
            }
            if(t.right != null) {
                node.add(t.right);
                col.add(co + 1);
                if(co >= max) {
                max = co + 1;}
            }
        }
        for(int i = min; i <= max; i++) {
            out.add(m.get(i));
        }
        return out;
    }
}