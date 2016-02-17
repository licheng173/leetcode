public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return  0;
         
         int[] p = new int[prices.length - 1];
         for(int i = 1; i < prices.length; i++)
         {
             p[i - 1] = prices[i] - prices[i - 1];
         }
         int n = p.length;
         
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = p[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            if(dp[i - 1] > 0)
                dp[i] = p[i] + dp[i - 1];
            else 
                dp[i] = p[i] + 0;
            max = Math.max(max, dp[i]);
        }
        if(max > 0)
        return max;
        else
        return 0;
    }
}
