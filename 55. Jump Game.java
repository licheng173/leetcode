public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length - 1; i++)
        {
            max= Math.max(nums[i] + i, max);
            if(max <= i) return false;
        }
        return true;
    }
}