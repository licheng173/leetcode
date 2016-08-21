public class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        int lo = 0; 
        int hi = length - 1;
        int mid;
        while(lo < hi) {
            mid = lo + (hi - lo) / 2;
            System.out.println(mid);
            if(nums[mid] > nums[hi]) {
                lo = mid + 1;
            }
            else if(nums[mid] < nums[hi]) {
                hi = mid; 
            }
        }
        return nums[lo];
    }
}