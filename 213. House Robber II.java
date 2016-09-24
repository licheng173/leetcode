public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp1 = new int[nums.length + 1];
        int[] dp2 = new int[nums.length + 1];
        dp2[0] = 0;
        dp2[1] = nums[0];
        dp1[0] = 0;
        dp1[1] = 0;
        for(int i = 2; i <= nums.length; i++) {
            dp1[i] = Math.max(dp1[i - 1], nums[i - 1] + dp1[i - 2]);
            dp2[i] = Math.max(dp2[i - 1], nums[i - 1] + dp2[i - 2]);
        }
        return Math.max(dp1[nums.length], dp2[nums.length - 1]);
        
    }
}

public int rob(int[] nums) {
    return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
}

public int rob(int[] nums, int lo, int hi) {
    int preRob = 0, preNotRob = 0, rob = 0, notRob = 0;
    for (int i = lo; i <= hi; i++) {
        rob = preNotRob + nums[i];
        notRob = Math.max(preRob, preNotRob);
        
        preNotRob = notRob;
        preRob = rob;
    }
    return Math.max(rob, notRob);
}