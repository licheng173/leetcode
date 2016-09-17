public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> list = new ArrayList<String>();
        String[] sample = {"0", "1", "8", "6", "9"};
        String[] sample2 = {"0","1","8","9","6"};
        List res = find(n, n, sample, sample2);
        return res;
    }
    
    public List<String> find(int n, int length, String[] sample, String[] sample2) {
        List<String> p = new ArrayList<String>();
        if(n == 0) return p;
        if(n == 1) {
            for(int i = 0; i < 3; i++) {
                p.add(sample[i]);
            }
            return p;
        }
        List<String> dd = find(n - 2, length, sample, sample2);
        if(dd.size() == 0) {
            if(n != length) {
                dd.add("00");
            }
            for(int i = 1; i < 5; i++) {
                dd.add(sample[i] + sample2[i]);
            }
            return dd;
        }
        
        for(String str : dd) {
            String tmp = str;
            if(n != length) {
                p.add(sample[0] + str + sample2[0]);
            }
            for(int i = 1; i < 5; i++) {
                p.add(sample[i] + str + sample2[i]);
            }
        }
        
        return p;
    }
}

//more consice
public List<String> findStrobogrammatic(int n) {
    return helper(n, n);
}

List<String> helper(int n, int m) {
    if (n == 0) return new ArrayList<String>(Arrays.asList(""));
    if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
    
    List<String> list = helper(n - 2, m);
    
    List<String> res = new ArrayList<String>();
    
    for (int i = 0; i < list.size(); i++) {
        String s = list.get(i);
        
        if (n != m) res.add("0" + s + "0");
        
        res.add("1" + s + "1");
        res.add("6" + s + "9");
        res.add("8" + s + "8");
        res.add("9" + s + "6");
    }
    
    return res;
}