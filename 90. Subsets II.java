public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> outList = new ArrayList<List<Integer>>();
        List<Integer> li = new ArrayList<>();
        outList.add(li);
        int start = 0;
        int count = 0;
        for(int i = 0; i < length; i++) {
            if(i > 0 && nums[i] != nums[i - 1]) {
                start = 0;
            }
            else {
                start = count;
            }
            count = outList.size();
            for(int j = start; j < count; j++) {
                List<Integer> list = new ArrayList<>(outList.get(j));
                list.add(nums[i]);
                outList.add(list);
            }
        }
        return outList;
    }
}

//back tracking
public class Solution {
     List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums,0,new ArrayList<>());
        res.add(new ArrayList<>() );
        return res;
    }
    
    private void helper(int nums[], int start, List<Integer> ans){
        // List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(start==nums.length){
            return;
        }
        
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1]) continue;
            ans.add(nums[i]);
            res.add(new ArrayList(ans));
            helper(nums,i+1,ans);
            ans.remove(ans.size()-1);
        }
    }
}