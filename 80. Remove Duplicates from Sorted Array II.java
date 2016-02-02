public class Solution {
    public int removeDuplicates(int[] nums) {
        int duplicate = 0;
        if(nums.length <= 2) return nums.length;
        int before = 0;
        int head = 1;
        while(head < nums.length)
        {
            if(nums[head] == nums[head - 1])
            {
                if(duplicate == 0)
                {
                    nums[++before] = nums[head++];
                    duplicate++;
                }
                else
                    head++;
            }
            else
            {
                nums[++before] = nums[head++];
                duplicate = 0;
            }
        }
        return before + 1;
    }
}