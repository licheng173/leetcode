public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }
        int length = words.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < length; i++) {
            if(words[i].equals(word1)) {
                for(int j = 0; j < length; j++) {
                    if(words[j].equals(word2)) {
                        if(Math.abs(i - j) < min) {
                            min = Math.abs(i - j);
                        }
                        if(j > i) break;
                    }
                }
            }
        }
        return min;
    }
}

//one loop O(n)
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }
        int length = words.length;
        int min = Integer.MAX_VALUE;
        int pos1 = -1;
        int pos2 = -1;
        for(int i = 0; i < length; i++) {
            if(words[i].equals(word1)) {
                pos1 = i;
            }
            if(words[i].equals(word2)) {
                pos2 = i;
            }
            if(pos1 != -1 && pos2 != -1) {
                min = Math.min(min, Math.abs(pos1 - pos2));
            }
        }
        return min;
    }
}

//