public class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++) {
            if(!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int i = 0; 
        int j = 0;
        int min = Integer.MAX_VALUE;
        while(i < l1.size() && j < l2.size()) {
            if(l1.get(i) > l2.get(j)) {
                min = Math.min(min, l1.get(i) - l2.get(j));
                j++;
            }
            else {
                min = Math.min(min, l2.get(j) - l1.get(i));
                i++;
            }
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");