public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int max = 0;
        int[][] map = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 1; i <= matrix.length; i++) {
            for(int j = 1; j <= matrix[0].length; j++) {
                if(matrix[i -1][j - 1] - '0' == 0) {
                    map[i][j] = 0;
                }
                else {
                    int min = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]);
                    map[i][j] = min + 1;
                    max = Math.max(max, map[i][j]);
                    //System.out.println("dsf");
                }
            }
        }
        return max * max;
    }
}