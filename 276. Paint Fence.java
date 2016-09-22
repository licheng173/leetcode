public class Solution {
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        int adjacentColor = 0;
        int nonadjacent = k;
        for(int i = 2; i <= n; i++) {
            int tmp = adjacentColor;
            adjacentColor = nonadjacent;
            nonadjacent = (tmp + nonadjacent) * (k - 1);
        }
        return adjacentColor + nonadjacent;
    }
}