
//Binary search
public class Solution {
public int searchInsert(int[] nums, int target) {
    int low = 0, high = nums.length;
    while(low < high) {
        int mid = low + (high - low) / 2;
        if(nums[mid] < target)
            low = mid + 1;
        else
            high = mid;
    }
    return low;
}

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start <= end) {
            mid = start + (end - start + 1) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                end = mid - 1;
            }
            if(nums[mid] < target) {
                start = mid+1;
                System.out.println(start);
            }
        }
        
        return start;
    }
}