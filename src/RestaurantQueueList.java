
//List works as a Queue
public class RestaurantQueueList<E> implements RestaurantList<E> {
	
	private Node<E> first, last;
	private int size;
	
	
	public RestaurantQueueList(){
		first=null;
		last=null;
		size=0;
	}

	//Returns list size.
	public int size() {
		return size;
	}
	
	//Returns if list is empty.
	public boolean isEmpty(){
		return size==0;
	}
	
	//Adds to the end of the list. Works as an enqueue().
	public void add(E e) {
		// TODO Auto-generated method stub
		if(isEmpty()){
			first = new Node<E>(e, null);
			last = first;
		}
		else{
			last.setNext(new Node<E>(e, null));
			last = last.getNext();
		}
		size++;	
	}


	//Returns first element of the list. Works as first().
	public E get() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			return null;
		}
		return first.getElement();
	}

	//Returns only first element. If asked something else returns exception. Works as a first().
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(index==0){
			if(isEmpty()){
				return null;
			}
			return first.getElement();
		}else{
			throw new IndexOutOfBoundsException("Index out of bonds for a Queue List.");
		}
	}
	
	//Deletes first element. Works as a dequeue().
	public E remove(){
		if(isEmpty())
			return null;
		Node<E> ntr = first;
		first = first.getNext();
		if(size==1)
			last=null;
		E etr = ntr.getElement();
		size--;
		return etr;
	}
	
	//Deletes only first node. If asked something else returns exception. Works as a dequeue().
	public E remove(int index) throws IndexOutOfBoundsException{
		if(isEmpty())
			return null;
		if(index==0){
			Node<E> ntr = first;
			first = first.getNext();
			if(size==1)
				last=null;
			E etr = ntr.getElement();
			size--;
			return etr;
		}else{
			throw new IndexOutOfBoundsException("Index out of bonds for a Queue List.");
		}
	}
	
	

	//Intern Node class.
	private class Node<T>{
		private T element;
		private Node next;
		
		public Node(T element, Node next){
			this.element = element;
			this.next = next;
		}
		
		public T getElement() {
			return element;
		}
		
		public void setNext(Node n) {
			next = n;
		}
		
		public Node<T> getNext() {
			return next;
		}
	
		public void setElement(T t) {
			element = t;
		}
		
	}


}
