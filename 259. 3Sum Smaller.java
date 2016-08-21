public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);
    int sums = 0;
    for (int i = 0; i < nums.length-2; i++) {
            int lo = i+1, hi = nums.length-1, sum = target - nums[i];
            //System.out.println(sum);
            while (lo < hi) {
                if (nums[lo] + nums[hi] >= sum) {
                    hi--;
                }
                if (nums[lo] + nums[hi] < sum) {
                    sums += hi - lo;
                    lo++;
                }
            }
    }
    return sums;
    }
}