// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer s;
    boolean isPeeked;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;
	    
 	    //max = Integer.MIN_VALUE;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    if(!isPeeked) {
	        s = it.next();
	        isPeeked = true;
	        return s;
	    }
	    return s;
	    
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(isPeeked) {
	        isPeeked = false;
	        Integer tm = s;
	        s = null;
	        return tm;
	    }
	    return it.next();
	    
	}

	@Override
	public boolean hasNext() {
	    return isPeeked || it.hasNext();
	}
}