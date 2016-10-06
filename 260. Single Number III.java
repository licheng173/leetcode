public class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for(int n : nums) {
            x ^= n;
        }
        int[] res = {0,0};
        int mat = x & ~(x - 1);
        for(int o : nums) {
            if((o & mat) == 0) {
                res[0] ^= o;
            }
            else {
                res[1] ^= o;
            }
        }
        return res;
    }
}