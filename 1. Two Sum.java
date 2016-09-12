public class Solution {
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

//Amazon interview *****************************************
public class Solution {
    public List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //Arrays.sort(nums);
        if(nums == null || nums.length < 2) return result;
        int length = nums.length;
        for(int i = 0; i < length - 1; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int start = nums[i];
                int lo = i + 1;
                int sum = target - start;
                while(lo < length) {
                    if(nums[lo] == sum){
                        List<Integer> li = new ArrayList<Integer>();
                        li.add(nums[i]);
                        li.add(nums[lo]);
                        result.add(li);
                        lo++;
                        while(lo < length && nums[lo] == nums[lo-1]){
                           lo++;
                        }
                    }
                    else
                    {
                        lo++;
                    }
                }
            }
        }
        return result;
    }
}

//test case
//(4,4,4) (0,0,0)  (1,1,2)