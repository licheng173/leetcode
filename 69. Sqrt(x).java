//most stupid solution
public class Solution {
    public int mySqrt(int x) {
        long i = 1;
        while(i * i < x) {
            i++;
        }
        if(i*i == x) return (int)i;
        else 
        return (int)(i - 1);
    }
}

//binary search
public class Solution {
    public int mySqrt(int x) {
      int start = 1;
    int end = x;
    int mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(mid == x / mid) return mid;
            else if(mid > x / mid) end = mid - 1;
            else start = mid + 1;
        }
        return start - 1;
    }
}

//牛顿逼近
 long r = x;
    while (r*r > x)
        r = (r + x/r) / 2;
    return (int) r;
