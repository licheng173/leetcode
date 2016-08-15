public class Solution {
    public static int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = nums[0];
        int min = nums[0];
        int m = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
               int  max1 = Math.max(Math.max(nums[i], max*nums[i]),min*nums[i]);
                //System.out.println(max+"MAX");
                int min1 = Math.min(Math.min(nums[i], min*nums[i]), max*nums[i]);
                // System.out.println(min+"M");
                 m = Math.max(max1,m);
                 max = max1;
                 min = min1;
        }
        return m;
    }
}

//
public class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if(length < 2) return nums[0];
        int[] maxSub = new int[length];
        int[] minSub = new int[length];
        maxSub[0] = nums[0];
        minSub[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < length; i++) {
            maxSub[i] = Math.max(Math.max(maxSub[i - 1] * nums[i], minSub[i - 1] * nums[i]), nums[i]);
            minSub[i] = Math.min(Math.min(minSub[i - 1] * nums[i], maxSub[i - 1] * nums[i]), nums[i]);
            res = Math.max(res, maxSub[i]);
        }
        return res;
        }
}