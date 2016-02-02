public class Solution {
    public static boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        if(s.length() == 0) return true;
        String S = s.toLowerCase();
        while(head < tail)
        {
            if(S.charAt(head) == S.charAt(tail))
           { head++;
            tail--;
           }
           else
           {
            if(Character.isLetterOrDigit(S.charAt(head)) && !Character.isLetterOrDigit(S.charAt(tail)))
            tail--;
            else if(!Character.isLetterOrDigit(S.charAt(head)) && Character.isLetterOrDigit(S.charAt(tail)))
            head++;
            else if(!Character.isLetterOrDigit(S.charAt(tail)) && !Character.isLetterOrDigit(S.charAt(head)))
            {head++;
            tail--;
            }
            else
            return false;
           }
        }
        return true;
    }
}