public class Solution {
    public int[] twoSum(int[] nums, int target){
        int[] index = {0,0};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length;i++ ){
            int index2 = target - nums[i];
            if(map.containsKey(index2)){
                index[1] = i + 1;
                index[0] = map.get(index2) + 1;
                return index;
            }else
            map.put(nums[i], i);
        }
        return index;
    }
}
