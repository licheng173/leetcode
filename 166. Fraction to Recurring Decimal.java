public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        HashMap<Long, Integer> map = new HashMap<>();
        StringBuilder build = new StringBuilder();
        if(denominator == 0) return "";
        if(numerator == 0) return "0";
        build.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long div = num / den;
        long mod = num % den;
        build.append(div);
        if(mod == 0) {
            return build.toString();
        }
        build.append('.');
        map.put(mod, build.length());
        while(mod != 0) {
            mod = mod * 10;
            build.append(mod / den);
            //System.out.println((mod));
            mod = mod % den;
            if(map.containsKey(mod)) {
                int i = map.get(mod);
                build.insert(i, "(");
                build.append(")");
                break;
            }
            else {
                map.put(mod, build.length());
            }
        }
        return build.toString();
    }
}