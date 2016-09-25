public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] num = new int[amount + 1];
        int sum = 1; 
        num[0] = 0;
        while(sum <= amount) {
            int min = -1;
            for(int coin : coins) {
                if(sum >= coin && num[sum - coin] != -1) {
                    int p = num[sum - coin] + 1;
                    if(min < 0) min = p;
                    min = Math.min(min, p);
                    
                }
            }
            num[sum] = min;
            //System.out.println(num[sum]);
            sum++;
        }
        return num[amount];
    }
}


public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        return Coin(dp, coins, amount);
    }
    
    public int Coin(int[] dp, int[] coins, int amount) {
        if(amount < 0) {
            return -1;
        }
        if(amount == 0) return 0;
        if(dp[amount] != 0) return dp[amount];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int tmp = Coin(dp, coins, amount - coins[i]);
            if(tmp >= 0) {
                min = Math.min(min, tmp + 1);
            }
        }
        if(min == Integer.MAX_VALUE) dp[amount] = -1;
        else dp[amount] = min;
        return dp[amount];
    }
}