public class Solution {
    public boolean isIsomorphic(String s, String t) {
    int[] m = new int[256];
    int[] n = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != n[t.charAt(i)]) return false;
            m[s.charAt(i)] = n[t.charAt(i)] = i+1;
        }
        return true;
    }
}

//
public class Solution {
    public boolean isIsomorphic(String s, String t) {
    if (t.length() != s.length())
        return false;
    Map index = new HashMap();
    for (Integer i=0; i<s.length(); ++i)
    {
        if (index.put(s.charAt(i)+"" , i) != index.put(t.charAt(i), i))
            return false;
    }
    return true;
    }
}
//hashmap
