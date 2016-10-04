public class ZigzagIterator {
    List<Integer> v1;
    List<Integer> v2;
    int i;
    int j;
    boolean flag;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        i = 0;
        j = 0;
        flag = false;
    }

    public int next() {
        flag = !flag;
        if(i < v1.size() && (flag || j >= v2.size())) {
            return v1.get(i++);
        }
        if(j < v2.size() && (!flag || i >= v1.size()) ) {
            return v2.get(j++);
        }
        return -1;
    }

    public boolean hasNext() {
       return i < v1.size() || j < v2.size();
    }
}

public class ZigzagIterator {
    Iterator<Integer> t1;
    Iterator<Integer> t2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        t1 = v1.iterator();
        t2 = v2.iterator();
    }

    public int next() {
        if(t1.hasNext()) {
            Iterator tmp = t1;
            t1 = t2;
            t2 = tmp; 
        }
        return t2.next();
    }

    public boolean hasNext() {
       return t1.hasNext() || t2.hasNext();
    }
}


//follow up
public class ZigzagIterator {
    LinkedList<Iterator> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator poll = list.remove();
        int result = (Integer)poll.next();
        if(poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}