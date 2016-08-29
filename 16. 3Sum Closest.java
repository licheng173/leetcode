public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int[] arr = new int[]{0,0,0};
        for(int i = 0; i < length - 2; i++) {
            int tar = target - nums[i];
            int lo = i + 1;
            int hi = length - 1;
            while(lo < hi) {
                if((nums[lo] + nums[hi]) == tar) {
                    return target;
                }
                else if(nums[lo] + nums[hi] > tar) {
                    if(nums[lo] + nums[hi] - tar < min) {
                        arr[0] = nums[i]; arr[1] = nums[lo]; arr[2] = nums[hi];
                        min = nums[lo] + nums[hi] - tar;
                    }
                    hi--;
                }
                else {
                    if(tar - nums[lo] - nums[hi] < min) {
                        arr[0] = nums[i]; arr[1] = nums[lo]; arr[2] = nums[hi];
                        min = tar - nums[lo] - nums[hi];
                    }
                    lo++;
                }
            }
             while(i < length - 3 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return arr[0] + arr[1] + arr[2];
    }
}