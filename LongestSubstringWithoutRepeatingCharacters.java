//second best use set easier than hashmap
import java.util.HashSet;
import java.util.Set;
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        
        return max;
    }
    public static void main(String[] args){
        String s = "abcdbac";
        int t = lengthOfLongestSubstring(s);
        System.out.print(t);
    }
}


//hashmao && two pointers
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length == 0 || s == null) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] charArray = s.toCharArray();
        int start = 0;
        int max = Integer.MIN_VALUE;
        //int end = length - 1;
        int i = start;
        while(i < length) {
            char p = charArray[i];
            if(map.containsKey(p)) {
                if(map.get(p) >= start) {
                    start = map.get(p);
                    start++;
                }
            }
            map.put(p, i);
            i++;
            max = Math.max(max, i - start);
            //System.out.println(start);
        }
        return max;
    }
}
