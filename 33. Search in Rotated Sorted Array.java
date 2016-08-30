public class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int start = 0;
        int end = length - 1;
        int index = -1;
        int mid = start + (end - start) / 2;
        while(start <= end) {
            if(nums[mid] > target) {
                if(target <= nums[end] && nums[mid] > nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            else if(nums[mid] < target) {
                if(nums[mid] < nums[end] && target > nums[end]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
               return mid;
            }
            mid = start + (end - start) / 2;
        }
        return index;
    }
}