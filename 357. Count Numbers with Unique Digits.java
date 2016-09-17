public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int numberCount = 10;
        int count = 10;
        int firstDigit = 9;
        for(int i = 2; i <= n; i++) {
            firstDigit = firstDigit * (numberCount - i + 1);
            count += firstDigit;
        }
        return count;
    }
}

//backtracking
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n > 10) {
            return countNumbersWithUniqueDigits(10);
        }
        int count = 1;
        long max = (long)Math.pow(10, n);
        boolean[] mark = new boolean[10]; 
        for(int i = 1; i < 10; i++) {
            mark[i] = true;
            count += countDigits(mark, i, max);
            mark[i] = false;
        }
        return count;
    }
    
    public int countDigits(boolean[] mark, int pre, long max) {
        int count = 0;
        if(pre < max) {
             count += 1;
        }
        else {
            return 0;
        }
        for(int i = 0; i < 10; i++) {
            if(!mark[i]) {
                mark[i] = true;
                int cur = 10 * pre + i; 
                count += countDigits(mark, cur, max);
                mark[i] = false;   
            }
        }
        return count;
        
    }
}