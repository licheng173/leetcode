public class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        int mid = (lo+hi)/2;
        if(nums[0] < nums[nums.length-1]) return nums[0];
        while(lo < hi)
        {
            if(hi - lo == 1)
            {
                mid = hi;
                break;
            }
            if(nums[mid] >= nums[lo])
            {
                lo = mid;
                mid = (lo + hi)/2;
            }
            else
            {
                hi = mid;
                mid = (lo + hi)/2;        
            }
        }    
    return nums[mid];
    }
}