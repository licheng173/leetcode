public class Solution {
    public String convert(String s, int numRows) {
        if(s.length() == 0 || numRows == 1)
        return s;
        int k = 0;
        int cycle = 2*numRows -2;
        StringBuilder build = new StringBuilder();
        for(int i = 0; i < numRows; i++)
        {
            while((i + cycle*k) < s.length())
            {
                if(((cycle - 2*i) + i + cycle*k) < s.length() && i != 0 && i != (numRows - 1))
                {
                    build.append(s.charAt(i + cycle*k)).append(s.charAt(i + (cycle - 2*i) + cycle*k));
                    k++;
                }
                else
                {
                    build.append(s.charAt(i + cycle*k));
                    k++;
                }
            }
            k = 0;
        }
        return build.toString();
    }
}
//other solutions
public String convert(String s, int nRows) {
    char[] c = s.toCharArray();
    int len = c.length;
    StringBuffer[] sb = new StringBuffer[nRows];
    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

    int i = 0;
    while (i < len) {
        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
            sb[idx].append(c[i++]);
        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
            sb[idx].append(c[i++]);
    }
    for (int idx = 1; idx < sb.length; idx++)
        sb[0].append(sb[idx]);
    return sb[0].toString();
}
