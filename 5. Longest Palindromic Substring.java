//time limit exceed
public class Solution {
    public String longestPalindrome(String s) {
        int point1 = 0;
        int point2 = 0;
        int max = 0;
        int start = 0;
        int end = 0;
        String t = new StringBuilder(s).reverse().toString();
        if(t.equals(s)) return s;
        //System.out.println(t);
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < t.length(); j++) {
                int startJ = j;
                int startI = i;
                while(startI < s.length() && startJ < t.length() && s.charAt(startI) == t.charAt(startJ)) {
                    //System.out.println(s.charAt(startI) + ""+ t.charAt(startJ));
                    startI++;
                    startJ++;
                    //System.out.println(startI);
                }
                
                if(startI - i > max) {
                    if(new StringBuilder(s.substring(i, startI)).reverse().toString().equals(s.substring(i, startI))) {
                    start = i;
                    end = startI;
                    max = startI - i;
                    }
                }
            }
        }
        return s.substring(start, end);
    }
}
//
public class Solution {
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
    
        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }
    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}