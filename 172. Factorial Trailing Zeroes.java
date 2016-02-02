public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        int x = 5;
        while(x <= n && x <= Integer.MAX_VALUE/5)
        {
            count = count + n/x;
            x = x*5;
        }
        int m = 2147483647/5;
        if(5*x > m && 5*x < 5*m)
        return count+1;
        else
        return count;
    }
}


public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0)
        {
           count = count + n/5;
           n = n/5;
        }
        return count;
    }
}