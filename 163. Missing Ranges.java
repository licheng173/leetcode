//ugly one
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        int length = nums.length;
        if(length == 0) {
            if(upper - lower == 0) list.add(lower + "");
            if(upper - lower >0) list.add(lower + "->" + upper);
            return list;
        }
        if(nums[0] - lower == 1) list.add(lower + "");
        if(nums[0] - lower > 1) list.add(lower + "->" + (nums[0] - 1));
        for(int i = 1; i < length; i++) {
            if(nums[i] - nums[i - 1] == 1) {
                continue;
            }
            if(nums[i] - nums[i - 1] == 2) {
                list.add((nums[i] - 1) + "");
            }
            if(nums[i] - nums[i - 1] > 2) {
                list.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
            }
        }
        if(upper - nums[length - 1] == 1) list.add(upper + "");
        if(upper - nums[length - 1] > 1) list.add((nums[length - 1] + 1) + "->" + upper);
        return list;
    }
}

//more concise and intelligient
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        for(int n : nums){
            int justBelow = n - 1;
            if(lower == justBelow) list.add(lower+"");
            else if(lower < justBelow) list.add(lower + "->" + justBelow);
            lower = n+1;
        }
        if(lower == upper) list.add(lower+"");
        else if(lower < upper) list.add(lower + "->" + upper);
        return list;
    }
}