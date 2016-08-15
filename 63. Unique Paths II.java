public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1;
                }
                else {
                    if(obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                    }
                    else {
                        if(i == 0) {
                            obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                        }
                        else if(j == 0) {
                            obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                        }
                        else {
                            obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                        }
                    }
                }
            }
        }
    return obstacleGrid[row - 1][column - 1];
    }
}

//use extra  O(n*m)space
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //dynamic programming
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;
        for(int i = 1 ; i <= m ; ++i)
            for(int j = 1 ; j <= n ; ++j)
                if(obstacleGrid[i-1][j-1] == 0)
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
        return dp[m][n];
    }
}
// use O(n) space
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int width = obstacleGrid[0].length;
    int[] dp = new int[width];
    dp[0] = 1;// very brillent
    for (int[] row : obstacleGrid) {
        for (int j = 0; j < width; j++) {
            if (row[j] == 1)
                dp[j] = 0;
            else if (j > 0)
                dp[j] += dp[j - 1];
        }
    }
    return dp[width - 1];
}