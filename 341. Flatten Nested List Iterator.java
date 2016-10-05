public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> it;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        it = new Stack<>();
        for(int i = nestedList.size() - 1; i >=0; i--) {
            it.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return it.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(it.size() > 0) {
            NestedInteger ns = it.peek();
            if(ns.isInteger()) {
                return true;
            }
            
            else {
                it.pop();
                for(int i = ns.getList().size() - 1; i>=0 ; i-- ) {
                    it.push(ns.getList().get(i));
                }
            }
        }
        return false;
       
    }
}