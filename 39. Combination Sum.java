//need review 

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	int length = candidates.length;
    	Arrays.sort(candidates);
    	List<List<Integer>> ret = new LinkedList<List<Integer>>();
    	sum(candidates,target,0,ret,new ArrayList<Integer>());
    	return ret;
    }
    public void sum(int[] candidates, int target,int index, List<List<Integer>> ll,List<Integer> l)
    {
    	if(target == 0) 
    	{
			ll.add(l);
			return;    		
    	}	
    	if(target < 0)
    		return;
    	int length = candidates.length;
    	for(int i = index; i < length; i++)
    	{
    		List<Integer> tmp = new ArrayList<Integer>(l);
    		tmp.add(candidates[i]);
    		sum(candidates, target - candidates[i],i,ll,tmp);
    	}
    }
}
//
