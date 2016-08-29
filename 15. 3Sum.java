public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> outList = new ArrayList<List<Integer>>();
        for(int i = 0; i < length - 2; i++) {
            int target = -nums[i];
            int lo = i + 1;
            int hi = length - 1;
            while(lo < hi) {
                if((nums[lo] + nums[hi]) == target) {
                    List<Integer> lis = new ArrayList<Integer>();
                    lis.add(nums[i]);
                    lis.add(nums[lo]);
                    lis.add(nums[hi]);
                    outList.add(lis); 
                    while(lo < length - 1 && nums[lo] == nums[lo + 1]) {
                        lo++;
                    }
                    while(hi > lo && nums[hi] == nums[hi - 1]) {
                        hi--;
                    }
                    lo++;
                    hi--;
                }
                else if(nums[lo] + nums[hi] > target) {
                    hi--;
                }
                else {
                    lo++;
                }
            }
             while(i < length - 3 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return outList;
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