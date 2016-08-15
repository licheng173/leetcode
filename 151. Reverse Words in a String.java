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