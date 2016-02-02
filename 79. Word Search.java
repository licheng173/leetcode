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