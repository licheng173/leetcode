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