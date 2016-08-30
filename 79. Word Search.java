public class Solution {
    public boolean exist(char[][] board, String word) {
        for(int j = 0; j < board.length; j++){
            for(int k = 0; k < board[0].length; k++){
                if(board[j][k] == word.charAt(0) && searchWord(0,word, board,j,k)){
                    return true;
                
                }
            }
        }
        return false;
    }
        
        public boolean searchWord(int level, String word, char[][] board, int row, int col){
            if(level == word.length())
                return true;
            if (row<0 || col<0 || row == board.length || col == board[row].length) 
                return false;
            if(board[row][col] != word.charAt(level))
                return false;
            char c = board[row][col];
            board[row][col] = '#';
            boolean flag = searchWord(level+1, word, board,row-1,col) || searchWord(level+1, word, board,row+1,col) ||  searchWord(level+1, word, board,row,col-1) || searchWord(level+1, word, board,row,col+1);
            board[row][col] = c;
            return flag;
            
        }
}

//TLE
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board == null || word.length() == 0) return false;
        int row = board.length - 1;
        int col = board[0].length - 1;
        char[] charArr = word.toCharArray();
        int[][] trace = new int[row + 1][col + 1];
        char start = charArr[0];
        boolean t = false;
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j <= col; j++) {
                if(board[i][j] == start) {
                    trace[i][j] = 1;
                    if(test(i, j, board, trace, charArr, 1, row, col)) {
                        return true;
                    }
                }
                
            }
        }
        return false;
    }


    public boolean test(int rowIndex, int colIndex, char[][] board, int[][] trace, char[] arr, int count, int row, int col) {
        if(count == arr.length) return true;
        boolean f1 = false;
        boolean f2 = false;
        boolean f3 = false;
        boolean f4 = false;
        if(colIndex < col && trace[rowIndex][colIndex + 1] != 1) {
            
            if(board[rowIndex][colIndex + 1] == arr[count]) {
                trace[rowIndex][colIndex + 1] = 1;
                f1 = test(rowIndex, colIndex + 1, board, trace, arr, count + 1, row, col);
            }
        }
        if(rowIndex < row && trace[rowIndex + 1][colIndex] != 1) {
            
            if(board[rowIndex + 1][colIndex] == arr[count]) {
                trace[rowIndex + 1][colIndex] = 1;
                f2 = test(rowIndex + 1, colIndex, board, trace, arr, count + 1, row, col);
            }
        }
        if(colIndex > 0 && trace[rowIndex][colIndex - 1] != 1) {
            
            if(board[rowIndex][colIndex - 1] == arr[count]) {
                trace[rowIndex][colIndex - 1] = 1;
                f3 = test(rowIndex, colIndex - 1, board, trace, arr, count + 1, row, col);
            }
        }
        if(rowIndex > 0 && trace[rowIndex- 1][colIndex] != 1) {
            
            if(board[rowIndex - 1][colIndex] == arr[count]) {
                trace[rowIndex - 1][colIndex] = 1;
                f4 = test(rowIndex - 1, colIndex, board, trace, arr, count + 1, row, col);
            }
        }
        trace[rowIndex][colIndex] = 0;
        return f1 || f2 || f3 || f4;
    }
}

//
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board == null || word.length() == 0) return false;
        int row = board.length - 1;
        int col = board[0].length - 1;
        char[] charArr = word.toCharArray();
        int[][] trace = new int[row + 1][col + 1];
        char start = charArr[0];
        boolean t = false;
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j <= col; j++) {
                if(board[i][j] == start) {
                    trace[i][j] = 1;
                    if(test(i, j, board, charArr, 0)) {
                        return true;
                    }
                }
                
            }
        }
        return false;
    }


    public boolean test(int rowIndex, int colIndex, char[][] board, char[] arr, int count) {
        if(count == arr.length) return true;
        if(rowIndex < 0 || rowIndex == board.length || colIndex < 0 || colIndex == board[0].length) return false;
        if(board[rowIndex][colIndex] != arr[count]) return false;  
        char c = board[rowIndex][colIndex];
        board[rowIndex][colIndex] = '#';
        boolean f = test(rowIndex, colIndex + 1, board, arr, count + 1) || test(rowIndex + 1, colIndex, board, arr, count + 1) ||test(rowIndex, colIndex - 1, board, arr, count + 1) || test(rowIndex - 1, colIndex, board, arr, count + 1);
        board[rowIndex][colIndex] = c;
        return f;
    }
}