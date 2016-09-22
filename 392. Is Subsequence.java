public class Solution {
    public boolean isSubsequence(String s, String t) {
        int start = 0;
        if(s.equals("")) return true;
        for(int i = 0; i < t.length() && start < s.length(); i++) {
            if(t.charAt(i) == s.charAt(start)) {
                start++;
            }
            if(start == s.length()) return true;
        }
        return false;
    }
}