public class Solution {
    public void wiggleSort(int[] nums) {
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            if(i % 2 == 0) {
                if(i != 0 && nums[i] > nums[i - 1]) {
                    int k = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = k;
                }
            }
            else {
                if(nums[i] < nums[i - 1]) {
                    int k = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = k; 
                }
            }
        }
    }
}