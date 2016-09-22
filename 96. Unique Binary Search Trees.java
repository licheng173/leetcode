public class Solution {
    public int numTrees(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                if(1 < j && j < i) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
                else {
                    dp[i] += dp[i - 1]; 
                }
            }
        }
        return dp[n];
    }
}