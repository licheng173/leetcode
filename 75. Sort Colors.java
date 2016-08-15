public class Solution {
    public void sortColors(int[] nums) {
        int r = 0;
        int w = 0;
        int b = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0) r++;
            if(nums[i] == 1) w++;
            if(nums[i] == 2) b++;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(r >0)
            {
                r--;
                nums[i] = 0;
            }
            else
            {
                if(w > 0)
                {
                    w--;
                    nums[i] = 1;
                }
                else
                nums[i] = 2;
            }
        }
    }
}


//one pass
public class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for(int i = 0; i <= right; i++)
        {
            if(nums[i] == 0) 
            {
                int t = nums[left];
                nums[left] = 0;
                nums[i] = t;
                left++;
            }
            if(nums[i] == 2)
            {
                int r = nums[right];
                nums[right] = 2;
                nums[i] = r;
                right--;
                i--;
            }
        }
    }
}

//using while
public class Solution {
    public void sortColors(int[] nums) {
       int low = 0;
       int high = nums.length - 1;
       int n = 0;
       while( n <= high) {
           if(nums[n] == 0) {
               nums[n] = nums[low];
               nums[low] = 0;
               low++;
               //n++;
           }
          if(nums[n] == 2) {
               nums[n] = nums[high];
               nums[high] = 2;
               high--;
               n--;
           }
               n++;
       }
    }
}