public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        List<Integer> l =  new ArrayList<>();
        helper(root, sum, out, l, 0);
        return out;
    }
    
    public void helper(TreeNode root, int sum, List<List<Integer>> out, List<Integer> list,int count) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null && count + root.val == sum) {
            list.add(root.val);
            out.add(list);
            return;
        }
        list.add(root.val);
        helper(root.left, sum, out, new ArrayList(list), count + root.val);
        helper(root.right, sum, out, new ArrayList(list), count + root.val);
    }
}