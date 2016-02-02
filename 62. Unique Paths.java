//dynamic programming
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                board[i][j] = 1;    
            }
        }
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
                board[i][j] = board[i][j - 1] + board[i - 1][j];
        }
        return board[m - 1][n - 1];
    }
}

//optical
public class Solution {
    public int uniquePaths(int m, int n) {
        int[] board = new int[n];
        for(int j = 0; j < n; j++)
        {
            board[j] = 1;   
        }
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
                board[j] = board[j - 1] + board[j];
        }
        return board[n - 1];
    }
}
