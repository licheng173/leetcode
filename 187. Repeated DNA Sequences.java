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