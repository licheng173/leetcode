public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix.length == 0)
            return list;
        int rowL = matrix.length;
        int colL = matrix[0].length;
        int row = 0;
        int col = 0;
        int state = 0;
        int level = 0;
        list.add(matrix[0][0]);
       // List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < (rowL * colL - 1); i++)
        {
           
            switch(state){
                case 0:
                    {
                        if(col == colL - 1 - level)
                        {
                            state  = 1;
                            row++;
                        }
                        else
                        col++;
                    }
                    break;
                case 1:
                    {
                        if(row == rowL - 1 - level)
                        {
                            state  = 2;
                            col--;
                        }
                        else
                        row++;
                    }
                    break;
                case 2:
                    {
                        if(col == level)
                        {
                            state = 3;
                            row--;
                        }
                        else
                        col--;
                    }
                    break;
                case 3:
                    {
                        if(row - level == 1)
                        {
                            state = 0;
                            col++;
                            level++;
                        }
                        else
                        row--;
                    }
                    break;
            }
             list.add(matrix[row][col]);
            
        }
        return list;
    }
}
//
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;
    }
}