public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> outList = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        factor(outList, n, 2, n - 1,list);
        return outList;
    }
    public void factor(List<List<Integer>> outList, int n, int start, int end, List<Integer> list) {
        if(n == 1 && list.size() != 0) {
            outList.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= end; i++) {
            if(n % i != 0) continue;
            list.add(i);
            factor(outList, n/i, i, n/i, list);
            list.remove(list.size() - 1);
        }
    }
}

//faster
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> element = new ArrayList<>();
        helper(list, n, 2, element, (int)Math.sqrt(n));
        return list;
    }
    public void helper(List<List<Integer>> list, int n, int start, List<Integer> element, int upper) {
        if(n == 1 &&element.size() > 1) {
            list.add(new ArrayList<Integer>(element));
                return;
        }
        for(int i = start; i <= n; i++) {
            if(i > upper) {
                i = n;
            }
            if(n %i == 0) {
                element.add(i);
                helper(list,n/i,i,element,(int)Math.sqrt(n/i));
                element.remove(element.size() - 1);
            }
        }
    }
}