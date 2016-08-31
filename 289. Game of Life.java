public class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] bo =new int[row+2][col+2]; 
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                bo[i+1][j+1] = board[i][j];
            }
        }
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            { 
                board[i][j] = currentState(i+1,j+1,bo);
            }
        }
        
        
    }
    
    public int currentState(int i, int j, int[][] board)
    {
        int count = 0;
        count = board[i][j -1] + board[i][j+1]+board[i-1][j]+board[i+1][j];
        count += board[i-1][j+1] + board[i+1][j-1]+board[i+1][j+1]+board[i-1][j-1];
        if(board[i][j] == 1)
        {
            if(count <2) return 0;
            if(count ==2 || count == 3) return 1;
            if(count > 3) return 0;
            
        }
        else
        {
            if(count == 3) return 1;
            else
            return 0;
        }
     return 0;   
    }
}



public class Solution{

public void gameOfLife(int[][] board) {
    if(board == null || board.length == 0) return;
    int m = board.length, n = board[0].length;

    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            int lives = liveNeighbors(board, m, n, i, j);

            // In the beginning, every 2nd bit is 0;
            // So we only need to care about when the 2nd bit will become 1.
            if(board[i][j] == 1 && lives >= 2 && lives <= 3) {  
                board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
            }
            if(board[i][j] == 0 && lives == 3) {
                board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
            }
        }
    }

    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            board[i][j] >>= 1;  // Get the 2nd state.
        }
    }
}

public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
    int lives = 0;
    for(int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
        for(int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
            lives += board[x][y] & 1;
        }
    }
    lives -= board[i][j] & 1;
    return lives;
}
}



// third 
public class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board == null) return;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int c = getNei(board, i, j);
                if(board[i][j] == 1) {
                    if(c == 2 || c == 3) {
                        board[i][j] = 3;
                    }
                }
                else {
                    if(c == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >>> 1;
            }
        }
    }
    
    public int getNei(int[][] board, int row, int col) {
        int cnt = 0;
        for(int i=row-1; i<=row+1; i++){
                for(int j=col-1; j<=col+1; j++){
                    if(i>=0 && i<board.length && j>=0 && j<board[0].length){
                        cnt += board[i][j]&1;
                    }
                }
            }
            cnt-=board[row][col]&1;
            return cnt;
    }
}