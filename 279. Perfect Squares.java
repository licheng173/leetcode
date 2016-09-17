public class Solution {
    public int numSquares(int n) {
       int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            // dp[1] = 1;
            for(int i = 1; i <= n; i++) {
                int s = (int)Math.sqrt(i);
                for(int j = 1; j <= s; j++) {
                    dp[i] = Math.min((dp[i - j*j] + 1),dp[i]);
                   // System.out.println(dp[i]);
                }
            }
            return dp[n];
    }
}