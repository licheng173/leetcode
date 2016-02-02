public class Solution {
    public boolean exist(char[][] board, String word) {
        Queue<Character> wordStore = new Queue<Character>();
        for(int int i = 0; i < word.length(); i++){
            wordStore.add(word.charAt[i]);
        }
        char head = wordStore.poll();
        for(int j = 0; j < board.length; j++){
            for(int k = 0; k < board[0].length; k++){
                if(board[j][k] == head){
                    searchWord(head, board);
                }
            }
        }
        
        public void searchWord(char head, char[][] board, int row, int col){
            int r,c;
            r = row; 
            c = col;
            int rowLength = board.length;
            int colLength = board[0].length;
            HashMap<Character,Character> adjacent = new HashMap<Character>();
            for(int i = 0; i < 4; i++)
                if(r-1 >= 0)
                    adjacent.put(board[r-1][k],'u');
                if(r+1 <= rowLength)
                    adjacent.put(board[r+1][k],'d');
                if(c-1 >= 0)
                    adjacent.put(board[r][c-1],'l');
                if(c+1 <= colLength)
                    adjacent.put(board[r][c+1],'r');
            }
            while(!adjacent.empth()){
                char h = adjacent.pop();
                char f = wordStore.poll();
                if(h == f)
                {

                }
            }
            
        }
        
        
        
        }
    }
}