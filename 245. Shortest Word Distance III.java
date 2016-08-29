public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int length = words.length;
        int index1 = -1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < length; i++) {
            if(words[i].equals(word2)) {
                if(word1.equals(word2)) {
                    index2 = index1;
                }
                else {
                    index2 = i;
                }
            }
            if(words[i].equals(word1)) {
                index1 = i;
            }
            if(index1 != -1 && index2 != -1) {
                min = Math.min(Math.abs(index1 - index2), min);
            }
        }
        return min;
    }
}