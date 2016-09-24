public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if( nums.length == 0 ) return 0;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        for(int i = 1 ; i < nums.length; i++){
            if( nums[i] > nums[i-1] ){
                up[i] = down[i-1]+1;
                down[i] = down[i-1];
            }else if( nums[i] < nums[i-1]){
                down[i] = up[i-1]+1;
                up[i] = up[i-1];
            }else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
        }
        return Math.max(down[nums.length-1],up[nums.length-1]);
    }
}

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int ends_large = 1;
        int ends_small = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i-1]) ends_small = ends_large + 1;
            else if (nums[i] > nums[i-1]) ends_large = ends_small + 1;
        }
    return Math.max(ends_small, ends_large);
    }
}