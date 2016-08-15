//Time limit
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(target == 0) {
            return 1;
        }
        if(target < 0) 
        return 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
             sum += combinationSum4(nums, target - nums[i]);
        }
        return sum;
    }
}
//DP top-down
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] a = new int[target+1];
        Arrays.fill(a,-1);
        a[0] = 1;
        return combination(nums, target, a);
    }
    public int combination(int[] nums, int target, int[] a) {
        if(a[target] != -1) {
            return a[target];
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(target >= nums[i]) {
             sum += combination(nums, target - nums[i], a);
            }
        }
        a[target] = sum;
        return sum;
    }
}
//DP bottom-up
public int combinationSum4(int[] nums, int target) {
    int[] comb = new int[target + 1];
    comb[0] = 1;
    for (int i = 1; i < comb.length; i++) {
        for (int j = 0; j < nums.length; j++) {
            if (i - nums[j] >= 0) {
                comb[i] += comb[i - nums[j]];
            }
        }
    }
    return comb[target];
}