public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ar = new ArrayList<String>();
        int count = 0;
        if(nums.length == 0){
            return ar;
        }
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == (nums[i - 1] +1))
            {
                count++;
            }
            else
            {
                if(count != 0)
                {
                    String show = nums[i - count - 1] + "->" + nums[i - 1];
                    ar.add(show);
                    count = 0;
                }
                else
                    ar.add(Integer.toString(nums[i-1]));
            }
        }
        if(count == 0)
        ar.add(Integer.toString(nums[nums.length-1]));
        else
        ar.add(nums[nums.length - count - 1] + "->" + nums[nums.length - 1]);
        return ar;
    }
}