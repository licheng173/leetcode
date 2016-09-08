public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        int length = strs.length;
        for(int i = 0; i < length; i++) {
            String pre = strs[i];
            char[] ch = pre.toCharArray();
            Arrays.sort(ch);
            String af = String.valueOf(ch);
            if(!map.containsKey(af)) {
                List<String> l = new ArrayList<>();
                map.put(af, l);
            }
            map.get(af).add(pre);
        }
        for(List<String> m : map.values()) {
            out.add(m);
        }
        return out;
    }
}