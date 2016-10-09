public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        if(nums.length == 0 || nums == null) return r; 
        permu(nums,l,r,0);
        return r;
    }
    
    
    public void permu(int[] nums,List<Integer> l,List<List<Integer>> r, int start){
        int[] num = new int[nums.length];
        if(start == nums.length)
        {
            r.add(l);
            return;
        }
        for(int i = start; i < nums.length; i++){
            List<Integer> t = new ArrayList<Integer>(l);
            int tmp = nums[i];
            nums[i] = nums[start];
            nums[start] = tmp;
            //System.out.println(nums[start]);
            t.add(nums[start]);
            for(int j = 0; j < nums.length; j++){
                num[j] =nums[j];
            }
            permu(num, t,r,start+1);
            //System.out.println(nums[start]);
        }
    }
}


public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> list = new ArrayList<>();
   // Arrays.sort(nums); // not necessary
   backtrack(list, new ArrayList<>(), nums);
   return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
   if(tempList.size() == nums.length){
      list.add(new ArrayList<>(tempList));
   } else{
      for(int i = 0; i < nums.length; i++){ 
         if(tempList.contains(nums[i])) continue; // element already exists, skip
         tempList.add(nums[i]);
         backtrack(list, tempList, nums);
         tempList.remove(tempList.size() - 1);
      }
   }
} 

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        helper(nums, 0, out);
        return out;
    }
    public void helper(int[] nums, int index, List<List<Integer>> l) {
        if(index >= nums.length) {
            List<Integer> v = new ArrayList<Integer>();
            for(int m : nums) {
                v.add(m);
            }
            l.add(v);
        }
        for(int i = index; i < nums.length; i++) {
           swap(nums, index, i);
           helper(nums, index + 1, l);
           swap(nums, index, i);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    } 
}
