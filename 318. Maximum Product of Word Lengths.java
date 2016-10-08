public class Solution {
    public int maxProduct(String[] words) {
        int[] by = new int[words.length];
        int max = 0;
        for(int i = 0; i < words.length; i++) {
            int val = 0;
            for(int j = 0; j < words[i].length(); j++) {
               val |= 1 << (words[i].charAt(j) - 'a');
            }
            by[i] = val;
        }
        
        for(int i = 0; i < words.length; i++) {
            for(int j = 1; j < words.length; j++) {
                if((by[i] & by[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }
}