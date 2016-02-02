
//complexity 3*lgn
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = lo + (lo+hi)/2;
        int[] se = new int[2];
        int flag = 0;
        while(lo <= hi)
        {
            if(nums[mid] > (target))
                hi = mid - 1;
            if(nums[mid] < (target))
                lo = mid + 1;
            if(nums[mid] == target)
                {flag = 1;break;}
            mid = (lo + hi)/2;
        }
        lo = 0;
        hi = nums.length - 1;
        mid = lo + (lo+hi)/2;
        while(lo <= hi)
        {
            if((float)nums[mid] > (target + 0.5))
                hi = mid - 1;
            if((float)nums[mid] < (target+0.5))
                lo = mid + 1;
            mid = (lo + hi)/2;
        }
        se[1] = lo - 1;
        lo = 0;
        hi = nums.length - 1;
        mid = lo + (lo+hi)/2;
        while(lo <= hi)
        {
            if((float)nums[mid] > (target - 0.5))
                hi = mid - 1;
            if((float)nums[mid] < (target - 0.5))
                lo = mid + 1;
            mid = (lo + hi)/2;
        }
        
        se[0] = lo;
       if(flag != 1)
       {
           se[0] = -1;
           se[1] = -1;
       }
       return se;
    }
}

//more simple and faster
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] ret = new int[]{-1, -1};
        // Search for the left one
        while (i < j)
        {
            int mid = (i + j) /2;
            if (nums[mid] < target) 
                i = mid + 1;
            else 
                j = mid;
        }
        if(nums[i]!=target) 
            return ret;
        else 
            ret[0] = i;

    // Search for the right one
        j = nums.length-1;  // We don't have to set i to 0 the second time.
        while (i < j)
        {
            int mid = (i + j) /2 + 1;   // Make mid biased to the right
            if (nums[mid] > target) 
                j = mid - 1;  
            else 
                i = mid;               // So that this won't make the search range stuck.
        }
        ret[1] = j;
        return ret; 
    }
}