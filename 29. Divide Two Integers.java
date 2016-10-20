public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int f = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long div = Math.abs((long)dividend);
        long dv = Math.abs((long)divisor);
        long c = 0;
        while(div >= dv) {
            long count = 1;
            long tm = dv;
            while(div > (tm << 1)) {
                tm <<= 1;
                count <<= 1;
                 
            }
           // System.out.println(count);
            div = div - tm;
            c += count;
        }
       // System.out.println(c);
        return (int)(c * f);
    }
}