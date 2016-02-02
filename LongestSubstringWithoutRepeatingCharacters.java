//worst case use hashmap but slow
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int count = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < (length- max); i ++){
            int j = i;
           
           while(!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
                count++;
                if(j == length-1){
                    break;
                }
                j++;
           }
           map.clear();
           if(max <= count){
               max = count;
           }
            count = 0;
          
        }
        return max;
    }
}

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
// best solution but not simple, use array to impliment hashmap function, most efficient but not easy to read
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lastIndices[] = new int[256];
        for(int i = 0; i<256; i++){
            lastIndices[i] = -1;
        }
        
        int maxLen = 0;
        int curLen = 0;
        int start = 0;
        int bestStart = 0;
        for(int i = 0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(lastIndices[cur]  < start){
                lastIndices[cur] = i;
                curLen++;
            }
            else{
                int lastIndex = lastIndices[cur];
                start = lastIndex+1;
                curLen = i-start+1;
                lastIndices[cur] = i;
            }
            
            if(curLen > maxLen){
                maxLen = curLen;
                bestStart = start;
            }
        }
        
        return maxLen;
    }
}
