public class Solution {
    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        count[0] = 0;
        for(int i = 1; i <= num; i = i * 2 ) {
            int q = i;
            count[i] = 1;
            while(q <= num && q < 2 * q) {
                count[q] = count[i] + count[q - i];
                q++;
            }
        }
        return count;
    }
}
//DP

public int[] countBits(int num) {
    int[] f = new int[num + 1];
    for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
    return f;
}