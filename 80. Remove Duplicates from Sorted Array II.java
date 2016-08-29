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

//second
public class Solution {
    public int removeDuplicates(int[] nums) {
     int length = nums.length;
        if(length == 0) return 0;
        int start = 0;
        int count = 1;
        for(int i = 1; i < length; i++) {
            if(nums[i] != nums[i - 1]) {
                count = 1;
                start++;
            }
            else {
                if(count == 1) {
                    count++;
                    start++;
                }
                else {
                    continue;
                }
            }
            nums[start] = nums[i];
        }
        return start + 1;
    }
}