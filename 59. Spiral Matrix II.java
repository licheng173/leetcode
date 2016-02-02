public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowFirst = 0;
        int rowEnd = n - 1;
        int colFirst = 0;
        int colEnd = n - 1;
        for(int k = 1; k <= n*n;)
        {
            for(int i = colFirst; i <= colEnd; i++)
            {
                matrix[rowFirst][i] = k++ ;
            }
            rowFirst++;
            for(int i = rowFirst; i <= rowEnd; i++)
            {
                matrix[i][colEnd] = k++;
            }
            colEnd--;
            for(int i = colEnd; i >= colFirst; i--)
            {
                matrix[rowEnd][i] = k++;
            }
            rowEnd--;
            for(int i = rowEnd; i > colFirst; i--)
            {
                matrix[i][colFirst] = k++;
            }
            colFirst++;
        }
        return matrix;
    }
}
