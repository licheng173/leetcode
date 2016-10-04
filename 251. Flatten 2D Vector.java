public class Vector2D implements Iterator<Integer> {
    Queue<Iterator> q;
    Iterator<Integer> t;
    public Vector2D(List<List<Integer>> vec2d) {
        q = new LinkedList<>();
        for(List<Integer> l : vec2d) {
            Iterator tm = l.iterator();
            if(tm.hasNext()) 
                q.add(l.iterator());
        }
        if(q.size() > 0)
        t = q.remove();
        else
        t = null;
    }

    @Override
    public Integer next() {
        return t.next();
    }

    @Override
    public boolean hasNext() {
        if(t == null) return false;
        if(t.hasNext()) {
            return true;
        }
        else if(q.size() != 0) {
            Iterator<Integer> tm = q.remove();
            t = tm;
            return true;
        }
        return false;
    }
}

public class Vector2D {
    int indexList, indexEle;
    List<List<Integer>> vec; 
    
    public Vector2D(List<List<Integer>> vec2d) {
        indexList = 0;
        indexEle = 0;
        vec = vec2d;
    }

    public int next() {
        return vec.get(indexList).get(indexEle++);
    }

    public boolean hasNext() {
        while(indexList < vec.size()){
            if(indexEle < vec.get(indexList).size())
                return true;
            else{
                indexList++;
                indexEle = 0;
            }
        }
        return false;
    }
}