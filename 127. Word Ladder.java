public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        wordList.add(endWord);
        Set<String> record = new HashSet<>();
       int dis = 1;
        while(q.size() > 0) {
             int l = q.size();
            for(int i = 0; i < l; i++) {
                String top = q.remove();
                if(top.equals(endWord)) return dis;
                helper(top, wordList, q);
                
            }
            dis++;
        }
        return 0;
    }
    
    public void helper(String word, Set<String> wordList, Queue<String> q) {
        wordList.remove(word);
        char[] ca = word.toCharArray();
        for(int p = 0; p < word.length(); p++) {
            char l = ca[p];
            for(int i = 0; i < 26; i++) {
                int cA = (int)'a' + i;
                ca[p] = (char)cA;
                if(wordList.contains(String.valueOf(ca))) {
                    String vv = String.valueOf(ca);
                    //System.out.println(vv);
                    wordList.remove(vv);
                    q.add(vv);
                }
            }
            ca[p] = l;
        }
    }
}