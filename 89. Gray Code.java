public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ls = new ArrayList<Integer>();
        ls.add(0); 
        for(int i = 2; i <= (int)Math.pow(2, n); i = i * 2) {
            for(int j = ls.size() - 1; j >= 0; j--) {
                int k = (i / 2) | ls.get(j);
                ls.add(k);
            }
        }
        return ls;
    }
}