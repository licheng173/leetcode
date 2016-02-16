public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int length = height.length;
        int j,i;
        i = 0;
        j = length - 1;
        while(i <j)
        {
            
            max = Math.max(Math.min(height[j],height[i])*(j - i),max);
            
            if(height[j] >height[i])
            {
                i++;            
            }
            else
            {
                j--;
            }
        }
        return max;
    }
}