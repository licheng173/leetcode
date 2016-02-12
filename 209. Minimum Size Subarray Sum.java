public class Solution {
     public static int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int sum = 0;
        int i = 0;
        int min = Integer.MAX_VALUE;
        while(i < nums.length)
        {
            
            if(sum < s && i < nums.length)
            {
                sum = sum + nums[i];
                i++;
            }
            //System.out.println(sum+ "sum"); 
            //System.out.println(i+ "i"); 
            while( sum >= s)
            {   min = Math.min(i - start ,min);
                //System.out.println(sum+ "min"); 
                //System.out.println(min+"min"); 
                sum = sum - nums[start];
                start++;
               // System.out.println(start+"st");
            }
        }
        if (min == Integer.MAX_VALUE)
        return 0;
        else 
        return min;
    }
}