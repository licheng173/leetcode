public class Solution {
    public boolean isValidSudoku(char[][] board) {     
        for(int i = 0; i < 9; i++)
        {
            for(int j =0; j < 9; j++)
            {
                if(!isPartialValid(board,i,0,i,8)) return false;
                if(!isPartialValid(board,0,j,8,j)) return false;
            }
        }       
        for(int m = 0; m < 3; m++)
        {
            for(int n = 0; n < 3; n++)
            {
                if(!isPartialValid(board,3*m,3*n,2+3*m,2+ 3*n))
                return false;
            }
        }
        return true;
    }   
    public boolean isPartialValid(char[][] board, int x1,int y1, int x2, int y2){
        HashSet<Character> s = new HashSet<Character>();
        for(int i = x1; i < x2+1; i++)
        {
            for(int k = y1; k < y2+1; k++)
            {
                
                if(s.contains(board[i][k]))
                return false;
                else if(board[i][k] != '.')
                s.add(board[i][k]);
            }
        }
        return true;
    }
}