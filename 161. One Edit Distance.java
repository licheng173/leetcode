public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 1) return false;
        int count = 0;
        if(s.length() == t.length())
        {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) - t.charAt(i) != 0) {
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

//more concise
public boolean isOneEditDistance(String s, String t) {
    for (int i = 0; i < Math.min(s.length(), t.length()); i++) { 
        if (s.charAt(i) != t.charAt(i)) {
            if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
                return s.substring(i + 1).equals(t.substring(i + 1));
            else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
                return s.substring(i).equals(t.substring(i + 1));               
            else // s is longer than t, so the only possibility is deleting one char from s
                return t.substring(i).equals(s.substring(i + 1));
        }
    }       
    //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t 
    return Math.abs(s.length() - t.length()) == 1;        
}