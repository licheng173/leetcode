/* Find all possible combinations of k numbers that add up to 
 * a number n, given that only numbers from 1 to 9 can be used 
 * and each combination should be a unique set of numbers.
*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
    	if(n == 0) return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> c = new ArrayList<Integer>();
        int level = 0;
        int index = 0;
        cal(k, n, res, c, level,index);
        return res;
    }

    public void cal(int k, int target, List<List<Integer>> res, List<Integer> c, int level, int index){
    	if(target == 0 && level == k){
    		res.add(c);
    		return;
    	}

    	for(int i = index; i < 9; i++){
    		if((target - i - 1) >= 0 && level < k)
    		{	
    			List<Integer> tmp = new ArrayList<Integer>(c);
    			tmp.add(i+1);
    		    //System.out.println(level + "  " + index);
    			cal(k, target - i - 1, res, tmp, level+1, i+1);
    		}
    		else
    			break;
    	}
    }
}