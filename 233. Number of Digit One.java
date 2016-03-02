public class Solution {
    public int countDigitOne(int n) {
        int sum = 0;
       for(long k = 1; k <= n; k *= 10) {
           long m = n/k; long t = n%k;
           sum += (m + 8)/10 * k + ((m%10 == 1) ? t + 1: 0);
       }
       return sum;
    }
}