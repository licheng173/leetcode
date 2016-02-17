public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0) return null;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer>  c = new LinkedList<Integer>();
        Set<String> s = new HashSet<String>();
        sum(candidates, target,0, res, c,s);
        return res;
    }

    public void sum(int[] candidates, int target, int  index, List<List<Integer>> res, List<Integer> c, Set<String> s){
    	if(target == 0)
    	{
    		if(s.add(c.toString()))
    		{
    			res.add(c);
    			return;
    		}
    	}

    	for(int i = index; i < candidates.length; i++){
    	    if(target - candidates[i] >= 0) //elimitate useless calculate
    	    {
    			List<Integer> tmp = new LinkedList<Integer>(c);
    			tmp.add(candidates[i]);
    			sum(candidates, target - candidates[i], i + 1, res, tmp,s);
    	    }
    	    else
    	    	break;
    	}
    }
}


/* special case
[1,1,2,7,6,10,5] 8
