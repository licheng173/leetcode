public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len == 0)
        return "";
        String tmp = strs[0];
        int  flag = 0;
        int i;
        for(i = 0; i < tmp.length(); i++)
        {
            for(int j = 1; j < len; j++)
            {
                if(strs[j].length() < i+1 || strs[j].charAt(i) != strs[0].charAt(i))
                {flag++;
                break;
                }
            }
            if(flag == 1)
            break;
        }
        return tmp.substring(0,i);
    }
}

//other solotion
public class Solution{
public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs!= null && strs.length > 0){
            Arrays.sort(strs);
            char [] a = strs[0].toCharArray();
            char [] b = strs[strs.length-1].toCharArray();

            for (int i = 0; i < a.length; i ++){
                if (b.length > i && b[i] == a[i]){
                    result.append(b[i]);
                }
                else {
                    return result.toString();
                }
            }
        return result.toString();
    }
    return "";
}
}