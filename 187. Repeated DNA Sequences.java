public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ls = new ArrayList<String>();
        int length = s.length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        if(length < 10) return ls;
        for(int i = 0; i <= length - 10; i++) {
            String cur = s.substring(i, i + 10);
           // System.out.println(cur);
            if(!map.containsKey(cur)) {
                map.put(cur, 1);
            }
            else {
                map.put(cur, 2);
            }
        }
        for(String va: map.keySet()) {
            if(map.get(va) == 2) {
                ls.add(va);
            }
        }
        return ls;
    }
}

//other way
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    Set<Integer> words = new HashSet<>();
    Set<Integer> doubleWords = new HashSet<>();
    List<String> rv = new ArrayList<>();
    char[] map = new char[26];
    //map['A' - 'A'] = 0;
    map['C' - 'A'] = 1;
    map['G' - 'A'] = 2;
    map['T' - 'A'] = 3;

    for(int i = 0; i < s.length() - 9; i++) {
        int v = 0;
        for(int j = i; j < i + 10; j++) {
            v <<= 2;
            v |= map[s.charAt(j) - 'A'];
        }
        if(!words.add(v) && doubleWords.add(v)) {
            rv.add(s.substring(i, i + 10));
        }
    }
    return rv;
}
}