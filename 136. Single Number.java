public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            if(!set.add(nums[i])) set.remove(nums[i]);
            
        }
        int out = 0;
        for (Integer value : set) {
	     out = value;
	    }
	    return out;
    }
}

//bit manipulation  using xor; exclusive or
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++)
        {
            res ^= nums[i]; 
        }
        return res;
    }
}
