public class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for(int i = 0; i < length; i++)
        {
            for(int j = i; j < length; j++)
            {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        for(int i = 0; i < length; i++)
        {
            int first = 0;
            int last = length - 1;
            while(first < last)
            {
                int tmp = matrix[i][first];
                matrix[i][first] = matrix[i][last];
                matrix[i][last] = tmp;
                first++;
                last--;
            }
        }
    }
}

//
public class Solution {
    public void rotate(int[][] matrix) {
        int end = matrix.length - 1;
        int start = 0;
        int p = end;
        while(start <= end) {
            for(int i = 0; i < p; i++) {
                int tmp = matrix[start][i + start];
                matrix[start][i + start] = matrix[end - i][start];
                matrix[end - i][start] = matrix[end][end - i];
                matrix[end][end - i] = matrix[i + start][end];
                matrix[i + start][end] = tmp;
            }
            start++;
            end--;
            p -= 2;
         }
    }
}
