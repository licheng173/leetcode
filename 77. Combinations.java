public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> outList = new ArrayList<List<Integer>>();
        List<Integer> inList = new ArrayList<Integer>();
        Combination(n, k, outList, inList, 0, 0);
        return outList;
    }
    
    public void Combination(int n, int k, List<List<Integer>> outList, List<Integer> inList, int count, int m) {
        if(count == k) {
            outList.add(new ArrayList(inList));
            return;
        }
        
        for(int i = m; i < n; i++) {
            inList.add(i + 1);
            Combination(n, k, outList, inList, count + 1, i + 1);
            inList.remove(inList.size() - 1);
        }
    }
}

//DP C(n,k) = f(C(n-1,k-1),n) + c(n-1,k);
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = this.combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(this.combine(n - 1, k));
        return result;
    }
}
