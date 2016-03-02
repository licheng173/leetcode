//Time Limit Exceed

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> li = new ArrayList<Integer>();
        Set<String> s = new HashSet<String>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        summary(result, li, 0, nums, 0,s);
        return result;
    }
    
    public void summary(List<List<Integer>> result, List<Integer> li, int target, int[]nums, int level,Set<String> s) {
        if(target == 0 && !li.isEmpty() && li.size() == 3){
            if(s.add(li.toString())){
            result.add(li);
            return;
            }
        }
        
        for(int i = level; i < nums.length; i++){
            if(li.size() <= 3){
                List<Integer> tmp = new ArrayList<Integer>(li);
                tmp.add(nums[i]);
                summary(result, tmp, target - nums[i], nums, i+1,s);
            }
            else
                break;
        }
    }
}

///Accepted Solution
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums == null || nums.length == 0) {
            return result;
        }
        int length = nums.length;
        for(int i = 0; i < length - 2; i++) {
            int ar = nums[i]; 
            int sum = 0 - ar;
            int lo = i+1;
            //System.out.println(sum);
            int hi = length - 1;
            while(lo < hi){
                
                if(nums[lo] + nums[hi] == sum){
                    //System.out.println(nums[lo]+"lo");
                    //System.out.println(nums[hi]+"hi");
                    List<Integer> li = new ArrayList<Integer>();
                    li.add(nums[i]);
                    li.add(nums[lo]);
                    li.add(nums[hi]);  
                    result.add(li);
                    while((lo < length - 1) && nums[lo] == nums[lo +1]){
                        lo++;
                    }
                    while(hi > lo && nums[hi] == nums[hi - 1]){
                        hi--;
                    }
                    lo++;
                    hi--;
                } 
                else if(nums[lo] + nums[hi] < sum) {
                    lo++;
                }
                else {
                    hi--;
                }
                
            }
            while(i < length - 3 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return result;
    }
}


//
public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>(); 
    for (int i = 0; i < num.length-2; i++) {
        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) lo++;
                else hi--;
           }
        }
    }
    return res;
}