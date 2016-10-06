public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ls = new ArrayList<String>();
        int length = (int)Math.pow(2, word.length());
        int count = 0;
        for(int i = 0;i < length; i++) {
            StringBuilder build = new StringBuilder();
            int j = 0;
            count = i;
            while(j < word.length()) {
                int num = 0;
                while((count & 1) == 1) {
                    num++;
                    j++;
                    count >>= 1;
                }
                if(num != 0) {
                    build.append(num);
                }
                else {
                    build.append(word.charAt(j));
                    count >>= 1;
                    j++;
                }
                
            }
            ls.add(build.toString());
            build = new StringBuilder();
        }
        return ls;
    }
}