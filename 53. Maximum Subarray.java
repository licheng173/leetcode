//nlogn
public class Solution {
    public int maxSubArray(int[] nums) {
        int low = 0;
        int[] point = new int[3];
        int high = nums.length - 1;
        point = maximumSubArray(nums,low,high);
        return point[2];
        
    }
    
    public int[] maximumSubArray(int[] nums, int low, int high)
    {
        int[] point = new int[3];
        if(high == low)
        {
            point[0] = low;
            point[1] = high;
            point[2] = nums[low];
            return point;
        }
        else
        {
            int[] pointLeft = new int[3];
            int[] pointRight = new int[3];
            int[] pointCross = new int[3];
            int mid = (low + high) / 2;
            pointLeft = maximumSubArray(nums, low, mid);
            pointRight = maximumSubArray(nums, mid + 1, high);
            pointCross = maximumCrossArray(nums, low, mid, high);
            if(pointLeft[2] >= pointRight[2] && pointLeft[2] > pointCross[2])
                return pointLeft;
            else if(pointRight[2] >= pointLeft[2] && pointRight[2] > pointCross[2])
                return pointRight;
            else
                return pointCross;
        }
    }
    
    public int[] maximumCrossArray(int[] nums, int low, int mid, int high)
    {
        int maxLeft = 0;
        int[] pointCross = new int[3];
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid; i >= low; i--)
        {
            sum = sum + nums[i];
            if(sum > leftSum)
            {
                leftSum = sum;
                maxLeft = i;
            }
        }
        pointCross[0] = maxLeft;
        sum = 0;
        int maxRight = 0;
        for(int i = mid + 1; i <= high; i++)
        {
            sum = sum + nums[i];
            if(sum > rightSum)
            {
                rightSum = sum;
                maxRight = i;
                
            }
        }
        pointCross[1] = maxRight;
        pointCross[2] = leftSum + rightSum;
        return pointCross;
    }
}

//O(n)
