
public interface RestaurantList <E>{
	
	//Adds an element at the end of the list. In Stack works as a push(E e), in Queue
	//works as a enqueue(E e).
	public void add(E e);
	
	//Returns the first element of the list. In Stack works as top(), in Queue as first().
	public E get();
	
	//Returns the index element of the list. In Stack works as top(), in Queue as first(), 
	//been able to return only the index 0, other indexes returns IndexOutOfBoundsException.
	public E get(int index) throws IndexOutOfBoundsException;
	
	//Returns true if the list is empty.
	public boolean isEmpty();
	
	//Returns the size of the list.
	public int size();
	
	//Removes the index element of the list. In Stack works as a pop(), in Queue works as a dequeue(),
	//been able to return only the index 0, other indexes returns IndexOutOfBoundsException.
	public E remove(int index) throws IndexOutOfBoundsException;
	
	//Removes an element of the list according to implementation. In Stack works as a pop(),
	//in Queue works as a dequeue().
	public E remove();
	
}






