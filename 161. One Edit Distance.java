public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 1) return false;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        int count = 0;
        if(s1.length == s2.length)
        {
            for(int i = 0; i < s1.length; i++) {
                if(s1[i] - s2[i] != 0) {
                    count++;
                }
            }
            if(count == 1) return true;
        }
        else {
            String l = s.length() > t.length() ? s : t;
            String sh = s.length() < t.length() ? s : t;
            int index = 0;
            for(int i = 0; i < l.length() && index < sh.length(); i++) {
                if(l.charAt(i) == sh.charAt(index)) {
                    index++;
                }
            }
            if(index == (l.length() - 1)) return true;
        }
        return false;
    }
}