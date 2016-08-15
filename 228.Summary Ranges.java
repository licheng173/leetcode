public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        int length = nums.length;
        int subLow = 0;
        int start = 0;
        int end = 0;
        if(length == 0) {
            return list;
        }
        for(int i = 0; i < length - 1; i++) {
            if((nums[i + 1] - nums[i]) == 1) {
                end++;
            }
            if((nums[i + 1] - nums[i]) != 1) {
                if(start == end) {
                    list.add(nums[i] + "");
                }
                else {
                    list.add(nums[start] + "->" + nums[end]);
                }
                start = i + 1;
                end = i + 1;
            }
        }
        if(start != end) {
            list.add(nums[start] + "->" + nums[end]);
            
        }
        else {
            list.add(nums[start] + "");
        }
        return list;
    }
}

//more concise
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        int length = nums.length;
        int subLow = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < length; i++) {
           int tmp = nums[i];
           while(i < (length - 1) && (nums[i+1] - nums[i]) == 1) {
               i++;
           }
           if(tmp == nums[i]) {
               list.add(tmp + "");
           }
           else {
               list.add(tmp + "->" + nums[i]);
           }
            
        }
        return list;
    }
}