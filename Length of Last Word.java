public class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length() - 1;
        int count = 0;
        if(len == -1) 
        return 0;
        while(len >= 0 && s.charAt(len) == ' ' ) len--;
        for(int i = len; i >= 0; i--)
        {
            if(Character.isSpace(s.charAt(i)))
            break;
            count++;
        }
        return count;
    }
}
//more concise
public int lengthOfLastWord(String s) {
    s = s.trim();
    int lastIndex = s.lastIndexOf(' ') + 1;
    return s.length() - lastIndex;        
}