public class Solution {
    public String countAndSay(int n) {
        if(n == 0) return "";
        if(n == 1) return "1";
        String first = "1";
        int k = 0;
        String arr = "";
        int count = 0;
        while(n > 1)
        {
            for(int i = 0; i < first.length();)
            {
                if(first.charAt(i) == first.charAt(k))
                {
                    i++;
                    count++;
                    continue;
                }
                arr = arr + count + first.charAt(k);
                k = i;
                count = 0;
            }
            arr = arr + count + first.charAt(k);
            first = arr;
            k = 0;
            count = 0;
            arr = "";
            n--;
        }
        return first;
    }
}

//more concise faster
public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "-1";
        String result = "1";

        for(int i = 1; i < n; i ++) {
            result = build(result);
        }
        return result;
    }

    private String build(String result) {
        StringBuilder builder = new StringBuilder();
        int p = 0;
        while(p < result.length()) {
            char val = result.charAt(p);
            int count = 0;

            while(p < result.length() && 
              result.charAt(p) == val){
                p ++;
                count ++;
            }
            builder.append(String.valueOf(count));
            builder.append(val);
        }
        return builder.toString();
    }
}
//the difference between stringbuilder and string concatenate
