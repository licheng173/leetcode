public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int roWLength = matrix.length - 1;
        int colLength = matrix[0].length - 1;
        int start = 0;
        while(start <= roWLength && colLength >= 0) {
            if(matrix[start][colLength] < target) {
                start++;
            }
            else if(matrix[start][colLength] > target) {
                colLength--;
            }
            else {
                return true;
            }
        }
        return false;
    }
}