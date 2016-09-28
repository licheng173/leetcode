public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return helper(nums, 0, nums.length - 1);
    }
    public TreeNode helper(int[] nums, int start, int end) {
        if(start > end) return null;
        if(start == end) {
            TreeNode t = new TreeNode(nums[start]);
            t.left = null;
            t.right = null;
            return t;
        }
        int mid = (start + end) / 2;
        TreeNode p = new TreeNode(nums[mid]);
        p.left = helper(nums, start, mid - 1);
        p.right = helper(nums, mid + 1, end);
        return p;
    }
    
}