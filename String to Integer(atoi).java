public class Solution {
    public int myAtoi(String str) {
        String s = "";
        for(int i = 0; i < str.length(); i++)
        {
            if(Character.isSpace(str.charAt(i)) && s.length() == 0)
                continue;
            else
            {
                if(Character.isDigit(str.charAt(i)) || str.charAt(i) == '+' || str.charAt(i) == '-')
                    s = s + str.charAt(i);
                else 
                    break;
            }
        }
        int sign = 0;
        int cint1 = 0;
        int cint2 = 0;
        for(int j = 0; j < s.length(); j++)
        {
            if(s.charAt(j) == '+')
            {
                sign++;
                cint1++;
            }
            if(s.charAt(j) == '-')
                {cint2++;
                sign++;
                }
        }
        int base = 0;
        if(s.length() == 0 || cint1 + cint2 > 1)
        return 0;
        if(s.length() == 1 && (s.charAt(0) == '+' || s.charAt(0) == '-'))
        return 0;
        for(int k = sign; k < s.length(); k++)
        {
            if(cint2 == 0 && (base > 214748364 ||(base == 214748364 && Character.getNumericValue(s.charAt(k)) > 7)))
            return 2147483647;
            if(cint2 == 1 && (base > 214748364 ||(base == 214748364  && Character.getNumericValue(s.charAt(k)) > 7)))
            return -2147483648;
            base = base * 10 + Character.getNumericValue(s.charAt(k));
        }
        return Integer.parseInt(s);
    }
}

//more concise version
public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int i = 0, len = str.length();
        int num = 0, sign = 1, bound = Integer.MAX_VALUE / 10;

        // 1. Remove whitespace
        while(i < len && str.charAt(i) == ' ') i ++;

        // 2. Handle signs
        if(i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = str.charAt(i++) == '-' ? -1 : 1;
        }

        // 3. Convert number
        while(i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            int digit = str.charAt(i++) - '0';
            boolean overlow = (num == bound && digit >= 8) || num > bound;
            if(overlow) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            num = num * 10 + digit;
        }

        return sign * num;
    }
}
