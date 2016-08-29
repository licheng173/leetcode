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

//8/27/2016
public class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int start = 0;
        int max = Integer.MIN_VALUE;
        int end = length - 1;
        while(start < end) {
            while(start < end &&height[start] < height[end]) {
                max = Math.max(max, height[start] * (end - start));
                start++;
            }
            while(start < end && height[start] >= height[end]) {
                max = Math.max(max, height[end] * (end - start));
                end--;
            }
        }
        return max;
    }
}