public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0; 
        int end = nums.length - 1;
        int mid = 0;
        while(start < end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                end = mid;
            }
            if(nums[mid] > target) {
                end = mid - 1;
            }
            if(nums[mid] < target) {
                start = mid + 1;
            }
        }
        int index1 = start;
        start = 0;
        end = nums.length - 1;
        while(start < end) {
            mid = start + (end - start + 1) / 2;
            if(nums[mid] == target) {
                start = mid;
            }
            if(nums[mid] > target) {
                end = mid - 1;
            }
            if(nums[mid] < target) {
                start = mid + 1;
            }
        }
        int index2 = end;
        if(nums[index1] == target && nums[index2] == target) {
            return new int[]{index1,index2};
        }
        else {
            return new int[]{-1, -1};
        }
    }
}