//递归  time limit exceed
public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        int start = 0;
        return decode(s, start);
    }
    
    public int decode(String s, int start) {
        if(start == s.length()) {
            return 1;
        }
        int count = 0;
        if(s.charAt(start) - '0' > 0) 
         {
             count += decode(s, start + 1);
             
         }
        if(start < s.length() - 1 && Integer.valueOf(s.substring(start, start + 2)) >= 10 && Integer.valueOf(s.substring(start, start + 2)) < 27) {
            count += decode(s, start + 2);
        }
        return count;
    }
}

//dynamic prigramming
public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) - '0' == 0 ? 0 : 1;
        for(int i = 2; i <= s.length(); i++) {
            if((s.charAt(i - 1) - '0') > 0 && (s.charAt(i - 1) - '0') < 10) {
                dp[i] += dp[i - 1]; 
            }
            if(Integer.valueOf(s.substring(i - 2, i)) >= 10 && Integer.valueOf(s.substring(i - 2, i)) < 27) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}