public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int sum = 0;
        int level = 0;
        level = depth(nestedList, 1);
        return depthSum(nestedList, level);
    }
    
    public int depth(List<NestedInteger> nestedList, int level) {
        int max = level;
        for(NestedInteger nest: nestedList) {
            if(!nest.isInteger()) {
                List<NestedInteger> tm = nest.getList();
                max = Math.max(depth(tm, level + 1), max);
            }
        }
        return max;
    }
    
    public int depthSum(List<NestedInteger> nestedList, int level) {
        int result = 0;
        for(NestedInteger nest : nestedList) {
            if(nest.isInteger()) {
                result += nest.getInteger() * level;
            }
            else {
                List<NestedInteger> list = nest.getList();
                result += depthSum(list, level - 1) ;
            }
        }
        return result;
    }
}

//one pass
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int result = 0;
        int res = 0;
        while(!nestedList.isEmpty()) {
            List<NestedInteger> ls = new ArrayList<>();
            for(NestedInteger nest : nestedList) {
                if(nest.isInteger()) {
                    res += nest.getInteger();
                }
                else {
                    ls.addAll(nest.getList());
                }
            }
            result += res;
            nestedList = ls;
        }
        return result;
    }
}