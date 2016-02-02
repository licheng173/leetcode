//hashmap
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> duplicate = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!duplicate.containsKey(nums[i]))
            {
                duplicate.put(nums[i],i);
            }
            else
            {
               if((i - duplicate.get(nums[i])) <= k)
               {
                   return true;
               }
               else
               {
                   duplicate.put(nums[i],i);
               }
            }
        }
        return false;
    }
}
//hashset & sliding windows
public class Solution{
  public boolean containsNearbyDuplicate(int[] nums, int k){
    Set<Integer> set = new HashSet<Integer>();
    for(int  i = 0; i < nums.length; i++){
      if(i > k) set.remove(nums[i - k -1]);
      if(!set.add(nums[i])) return true;

    }
  }
}