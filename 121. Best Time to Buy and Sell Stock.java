public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int a = 0;
        if(length <= 1) return 0;
        int max = 0;
        for(int i = 1; i < length; i++) {
            prices[i - 1] = prices[i] - prices[i - 1]; 
        }
        
        a = 0;
        for(int i = 0; i < length - 1; i++) {
            if(a >= 0) {
                a += prices[i];
                max = Math.max(a, max);
            }
            else {
                max = Math.max(Math.max(a, prices[i]), max);
                a  = prices[i];
            }
        }
        return max;
    }
}

//Kadane's algorithm
 public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
