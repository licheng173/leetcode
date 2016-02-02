public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        int i = n;
        while(i%2 == 0  )
        {
            i = i/2;
        }
        if(i == 1)
        return true;
        return false;
    }
}
//bit manipulation
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return ((n & (n - 1)) == 0 && n > 0);
    }
}