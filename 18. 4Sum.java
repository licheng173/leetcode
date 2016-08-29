public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> outList = new ArrayList<List<Integer>>();
        int target1, target2;
        if(length < 4) return outList;
        for (int i = 0; i < length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            target1 = target - nums[i];
            for ( int j = i + 1; j < length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                target2 = target1 - nums[j];
                int start = j + 1;
                int end = length - 1;
                while(start < end) {
                    if((nums[start] + nums[end]) == target2) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        if(!outList.contains(list))
                        outList.add(list);
                        while(start < length - 1 && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        while(end > start && nums[end] == nums[end - 1]) {
                            end --;
                        }
                        start++;
                        end--;
                    }
                    else if(nums[start] + nums[end] > target2) {
                        end--;
                    }
                    else {
                        start++;
                    }
                }
            }
        }
        return outList;
    }
}