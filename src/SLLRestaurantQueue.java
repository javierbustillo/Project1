public class SLLRestaurantQueue<E> implements RestaurantQueue<E> {
	
	private Node<E> first, last;
	private int size;
	
	public SLLRestaurantQueue(){
		first=null;
		last=null;
		size=0;
	}


	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
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

	@Override
	public void enqueue(E e) {
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

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	

	@Override
	public E first() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			return null;
		}
		return first.getElement();
	}
	
	public boolean isEmpty(){
		return size==0;
	}

	
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
