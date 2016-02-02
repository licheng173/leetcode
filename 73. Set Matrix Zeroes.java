//9ms extra spaca + n*n complexity
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> setRow = new HashSet<Integer>();
        Set<Integer> setCol = new HashSet<Integer>();
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(matrix[i][j] == 0)
                {
                    setRow.add(i);
                    setCol.add(j);
                }
            }
        }
        for(int i = 0; i < row; i ++)
        {
            for(int j = 0; j<col; j++){
                if(setRow.contains(i) || setCol.contains(j))
                matrix[i][j] = 0;
            }
        }
      
    }
}
//2ms
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return;
        int row = matrix.length;
         boolean fr = false,fc = false;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(matrix[i][j] == 0)
                {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[i][0] = 0; 
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < row; i ++)
        {
            for(int j = 1; j<col; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                   matrix[i][j] = 0;
            }
        }
        if(fr)
        {
            for(int i = 0; i < col; i++)
            {
                matrix[0][i] = 0;
        
            }
        }
        if(fc)
        {
            for(int j = 0; j < row; j++)
            {
                matrix[j][0] = 0;
            }
        }
      
    }
}
 
//more concise *****
public class Solution {
    public void setZeroes(int[][] matrix) {
   		int col0 = 1, rows = matrix.length, cols = matrix[0].length;
	    for (int i = 0; i < rows; i++) {
    	{

    	    if (matrix[i][0] == 0) col0 = 0;
        	for (int j = 1; j < cols; j++)
            {	
            	if (matrix[i][j] == 0)
                 	matrix[i][0] = matrix[0][j] = 0;
			}    	
    	}

    	for (int i = rows - 1; i >= 0; i--) 
    	{
        	for (int j = cols - 1; j >= 1; j--)
            {
            	if (matrix[i][0] == 0 || matrix[0][j] == 0)
               		matrix[i][j] = 0;
        	}	
        	if (col0 == 0) matrix[i][0] = 0;
    	}     
    }
}
