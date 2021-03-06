public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        int sum = 0;
        int max = 0;
        for(int i = 0; i < length; i++) {
            sum += nums[i];
            
            if(sum == k) max = i + 1;
            else if(map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
                System.out.println(map.get(sum - k));
            }
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
}