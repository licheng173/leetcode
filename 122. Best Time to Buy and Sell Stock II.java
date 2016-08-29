public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int max = 0;
        for(int i = 1; i < length; i++) {
            if(prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }
}