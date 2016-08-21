public class Solution {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        int peek = 0;
        for(int i = 1; i < length; i++) {
            if(nums[i] < nums[i - 1]) {
                peek = i - 1;
                break;
            }
            else {
                peek = i; 
            }
        }
        return peek;
    }
}