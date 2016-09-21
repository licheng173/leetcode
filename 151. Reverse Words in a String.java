public class Solution {
    public String reverseWords(String s) {
        if(s.trim().equals("")) return "";
        
        String[] newS = s.split("\\s+");
        StringBuilder build = new StringBuilder();
        for(int i = newS.length - 1; i >= 0; i--) {
            build.append(newS[i]).append(" ");
        }
        return build.toString().trim();   
    }
}

//coner case
// ""  , "   a   "

//
void reverseWords(string &s) {
    reverse(s.begin(), s.end());
    int storeIndex = 0;
    for (int i = 0; i < s.size(); i++) {
        if (s[i] != ' ') {
            if (storeIndex != 0) s[storeIndex++] = ' ';
            int j = i;
            while (j < s.size() && s[j] != ' ') { s[storeIndex++] = s[j++]; }
            reverse(s.begin() + storeIndex - (j - i), s.begin() + storeIndex);
            i = j;
        }
    }
    s.erase(s.begin() + storeIndex, s.end());
}
//
