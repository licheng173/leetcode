public class Solution {
    public int reverse(int x) {
        int flag = 0;
        int i = 0;
        if(x < 0) flag = 1;
        StringBuilder build = new StringBuilder();
        int p = Math.abs(x);
        if(p < 0) return 0;
        while(p != 0)
        {
            if((i > (Integer.MAX_VALUE/10)) || ((i == (Integer.MAX_VALUE/10)) && p%10 > 7)) return 0;
            build.append(p%10);
            p = p/10;
            i = Integer.valueOf(build.toString());
        }
        if(flag == 1)
        return (0 - i);
        else 
        return i;
    }
}
//
public int reverse(int x)
{
    int result = 0;

    while (x != 0)
    {
        int tail = x % 10;
        int newResult = result * 10 + tail;
        if ((newResult - tail) / 10 != result)
        { return 0; }
        result = newResult;
        x = x / 10;
    }

    return result;
}