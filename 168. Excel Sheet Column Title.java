public class Solution {
    public String convertToTitle(int n) {
        int mod;
        StringBuilder build = new StringBuilder();
        while(n > 0)
        {
            char c = (char)((n-1)%26 + 'A');
            build.append(c);
            n = (n-1)/26;
        }
        return build.reverse().toString();
    }
}