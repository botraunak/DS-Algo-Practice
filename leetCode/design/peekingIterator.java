// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> queue;
    Iterator<Integer> iterator;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        this.queue = new LinkedList<>();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(!queue.isEmpty())
            return queue.peek();
        if(iterator.hasNext()){
            int temp = iterator.next();
            queue.add(temp);
            return temp;
        }
        return null;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(queue.isEmpty())
            return iterator.next();
        return queue.poll();
	}

	@Override
	public boolean hasNext() {
	    if(!queue.isEmpty() || iterator.hasNext()) return true;
        return false;
	}
}