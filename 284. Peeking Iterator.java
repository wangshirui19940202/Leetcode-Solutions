// 284. Peeking Iterator

class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> itr;
    Integer cur = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
        itr = iterator;
        if (itr.hasNext())
	        cur = itr.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cur;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = cur;
        cur = itr.hasNext() ? itr.next() : null;
        return res;
	}

	@Override
	public boolean hasNext() {
	    return cur != null;
	}
}