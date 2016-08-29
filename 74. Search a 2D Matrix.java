public boolean searchMatrix(int[][] matrix, int target) {

    int row_num = matrix.length;
    int col_num = matrix[0].length;

    int begin = 0, end = row_num * col_num - 1;

    while(begin <= end){
        int mid = (begin + end) / 2;
        int mid_value = matrix[mid/col_num][mid%col_num];

        if( mid_value == target){
            return true;

        }else if(mid_value < target){
            //Should move a bit further, otherwise dead loop.
            begin = mid+1;
        }else{
            end = mid-1;
        }
    }

    return false;
}
///

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0][0] > target) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int lo = 0;
        int hi = row - 1;
        int mid = (lo + hi)/2; 
        while(lo <= hi)
        {
            if(matrix[mid][0] > target) hi = mid - 1;
            if(matrix[mid][0] < target) lo = mid + 1;
            if(matrix[mid][0] == target) return true;
            mid = (lo + hi)/2; 
        }
        
        row = hi;
        lo = 0;
        hi = col - 1;
        mid = (lo + hi) / 2;
        while(lo <= hi)
        {
            if(matrix[row][mid] > target) hi = mid - 1;
            if(matrix[row][mid] < target) lo = mid + 1;
            if(matrix[row][mid] == target) return true;
            mid = (lo + hi)/2; 
        }
        return false;
    }
}
/////not bInary search
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
