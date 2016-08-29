public class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int[] re = new int[length];
        int max = 0;
        for(int i = 0; i < length; i++) {
            if(max < i) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
            re[i] = max;
        }
        return true;
    }
}