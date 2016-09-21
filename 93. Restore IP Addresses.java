public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s.length() < 4 || s.length() > 12 || s == null) return res;
        int start = 0;
        storeAddress(res, s, "", start, 0);
        return res;
    }
    
    public void storeAddress(List<String> res, String s, String sub, int start, int count) {
        if(count == 4 && start != s.length()) return;
        if(count != 4 && start == s.length()) return;
        if(count == 4 && start == s.length()) {
            res.add(sub);
            return;
        }
        
        StringBuilder build = new StringBuilder(sub);
        if(s.charAt(start) == '0') {
            build.append("0");
            if(count != 3) build.append(".");
            storeAddress(res, s, build.toString(), start + 1, count + 1);
        }
        else {
            int sum = 0;
            for(int i = 0; i < 3 && start + i < s.length() && sum <= 255; i++) {
                sum += s.charAt(start + i) - '0';
                build.append(String.valueOf(sum % 10));
                if(count != 3) build.append(".");
                if(sum <= 255) {
                    storeAddress(res, s, build.toString(), start + i + 1, count + 1);
                    if(count != 3) build.deleteCharAt(build.length() - 1);
                }
                sum *= 10;
            }
        }
    }
}