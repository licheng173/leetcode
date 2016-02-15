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