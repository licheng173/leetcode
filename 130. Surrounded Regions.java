public class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board == null) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][n-1] == 'O')
                dfs(board, i, n-1); 
        }
    //Start from first and last row, turn '0' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);
            if (board[m-1][j] == 'O')
                dfs(board, m-1, j); 
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void dfs(char[][] board, int i, int j) {
        if(j < 0 || j >= board[0].length || i < 0 || i >= board.length) {
            return;
        }
        if (board[i][j] == 'O')
            board[i][j] = '*';
        if (i > 1 && board[i-1][j] == 'O')
            dfs(board, i-1, j);
        if (i < board.length - 2 && board[i+1][j] == 'O')
            dfs(board, i+1, j);
        if (j > 1 && board[i][j-1] == 'O')
            dfs(board, i, j-1);
        if (j < board[i].length - 2 && board[i][j+1] == 'O' )
            dfs(board, i, j+1);
    }
}

//unionfind
public class Solution {
    
    int[] unionSet; // union find set
    boolean[] hasEdgeO; // whether an union has an 'O' which is on the edge of the matrix
    
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        
        // init, every char itself is an union
        int height = board.length, width = board[0].length;
        unionSet = new int[height * width];
        hasEdgeO = new boolean[unionSet.length];
        for(int i = 0;i<unionSet.length; i++) unionSet[i] = i;
        for(int i = 0;i<hasEdgeO.length; i++){
            int x = i / width, y = i % width;
            hasEdgeO[i] = (board[x][y] == 'O' && (x==0 || x==height-1 || y==0 || y==width-1));
        }
        
        // iterate the matrix, for each char, union it + its upper char + its right char if they equals to each other
        for(int i = 0;i<unionSet.length; i++){
            int x = i / width, y = i % width, up = x - 1, right = y + 1;
            if(up >= 0 && board[x][y] == board[up][y]) union(i,i-width);
            if(right < width && board[x][y] == board[x][right]) union(i,i+1);
        }
        
        // for each char in the matrix, if it is an 'O' and its union doesn't has an 'edge O', the whole union should be setted as 'X'
        for(int i = 0;i<unionSet.length; i++){
            int x = i / width, y = i % width;
            if(board[x][y] == 'O' && !hasEdgeO[findSet(i)]) 
                board[x][y] = 'X'; 
        }
    }
    
    private void union(int x,int y){
        int rootX = findSet(x);
        int rootY = findSet(y);
        // if there is an union has an 'edge O',the union after merge should be marked too
        boolean hasEdgeO = this.hasEdgeO[rootX] || this.hasEdgeO[rootY];
        unionSet[rootX] = rootY;
        this.hasEdgeO[rootY] = hasEdgeO;
    }
    
    private int findSet(int x){
        if(unionSet[x] == x) return x;
        unionSet[x] = findSet(unionSet[x]);
        return unionSet[x];
    }
}