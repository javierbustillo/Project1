public class SLLRestaurantStack<E> implements RestaurantStack<E>{

	private Node<E> head;
	private int size;
	
	public SLLRestaurantStack() {
		head = null;
		size = 0;
	}
	
	@Override
	public void push(E e) {
		if(size==0) {
			Node<E> tmp = new Node<E>(e, null);
			head = tmp;
			size++;
		}
		else {
			Node<E> tmp = new Node<E>(e, head);
			head = tmp;
			size++;
		}
		
	}

	@Override
	public E pop() {
		if(size==0) {
			return null;
		}
		else {
			E tmp  = head.getElement();
			head = head.getNext();
			size--;
			return tmp;
			
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return null;
		}
		E tmp = head.getElement();
		
		return tmp;

	}
	
	private class Node<T>{
		private T element;
		private Node<T> next;
		
		public Node(T element, Node<T> next){
			this.element = element;
			this.next = next;
		}
		
		public T getElement() {
			return element;
		}
		
		public void setNext(Node<T> n) {
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
