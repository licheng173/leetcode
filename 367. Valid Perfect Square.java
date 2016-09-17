public class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        long start = 1;
        long end = num;
        long mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if(mid * mid == num) return true;
            else if(mid * mid > num) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
       
        return false;
    }
}

//1+3+5+7+9 = n*n
public boolean isPerfectSquare(int num) {
      if (num < 1) return false;
      for (int i = 1; num > 0; i += 2)
        num -= i;
      return num == 0;
    }


//
boolean isPerfectSquare(int num) {
      if (num < 1) return false;
      long t = num / 2;
      while (t * t > num) {
        t = (t + num / t) / 2;
      }
      return t * t == num;
    }
