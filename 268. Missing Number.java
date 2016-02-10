public class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = (1 + length) * length /2;
        int t= 0;
        for(int i = 0; i < length; i++)
        {
            t = t + nums[i];
        }
        return sum - t;
        
    }
}