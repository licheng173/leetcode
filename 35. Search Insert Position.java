public class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int i = 0;
        while(i < length)
        {
            if(nums[i] >= target)
                return i;
            i++;
        }
        return length;
    }
}
//Binary search
public class Solution {
public int searchInsert(int[] nums, int target) {
    int low = 0, high = nums.length;
    while(low < high) {
        int mid = low + (high - low) / 2;
        if(nums[mid] < target)
            low = mid + 1;
        else
            high = mid;
    }
    return low;
}