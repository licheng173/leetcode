public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        int i = 0;
        int max = 1;
        for(int j = 2; j <= nums.length; j++) {
            i = 1;
            int tmp = 0;
            while(i < j) {
                if(nums[i - 1] < nums[j - 1]) {
                    tmp = Math.max(dp[i] + dp[j], tmp);
                }
                i++;
            }
            dp[j] = Math.max(dp[j], tmp);
            max = Math.max(max, dp[j]);
        }
        
        return max;
    }
}

//binary search
public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int x : nums) {
        int i = 0, j = size;
        while (i != j) {
            int m = (i + j) / 2;
            if (tails[m] < x)
                i = m + 1;
            else
                j = m;
        }
        tails[i] = x;
        if (i == size) ++size;
    }
    return size;
}


"https://segmentfault.com/a/1190000003819886"