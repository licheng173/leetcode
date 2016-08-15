/* Find all possible combinations of k numbers that add up to 
 * a number n, given that only numbers from 1 to 9 can be used 
 * and each combination should be a unique set of numbers.
*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> outList = new ArrayList<List<Integer>>();
        List<Integer> inList = new ArrayList<Integer>();
        combination(k, n, outList, inList, 1);
        return outList;
    }
    
    public void combination(int k, int target, List<List<Integer>> outList, List<Integer> list, int start) {
        if(target == 0 && list.size() == k) {
            outList.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < 10 && target >= i ; i++) {
            list.add(i);
            combination(k, target - i,outList, list, i+1);
            list.remove(list.size() - 1);
        }
    }
}