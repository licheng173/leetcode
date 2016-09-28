public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] max = new int[1];
        helper(map, root, max);
        return max[0];
    }
    
    public boolean helper(Map<Integer, Integer> map, TreeNode root, int[] max) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            if(!map.containsKey(root.val)) 
                map.put(root.val, 1);
             else 
                map.put(root.val, map.get(root.val) + 1); 
            max[0] = max[0] + 1;
            return true;
        }
        boolean  left = helper(map, root.left, max);
        boolean  right = helper(map, root.right, max);
        if(right && left) {
            if(root.left != null && root.right == null && root.left.val == root.val) {
                map.put(root.left.val, map.get(root.left.val) + 1);
                max[0] = Math.max(map.get(root.left.val), max[0]);
                return true;
            }
            else if(root.right != null && root.left == null && root.right.val == root.val) {
                map.put(root.right.val, map.get(root.right.val) + 1);
                max[0] = Math.max(map.get(root.right.val), max[0]);
                return true;
            }
            else if(root.right != null && root.left != null && root.left.val == root.right.val && root.val == root.left.val) {
                map.put(root.right.val, map.get(root.right.val) + 1);
                max[0] = Math.max(map.get(root.left.val), max[0]);
                return true;
            }
        }
        return false;
    }
}