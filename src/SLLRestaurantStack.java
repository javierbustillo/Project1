
public class SLLRestaurantStack<E> implements RestaurantStack<E>{

	private Node head;
	private int size;
	
	public SLLRestaurantStack() {
		head = null;
		size = 0;
	}
	
	@Override
	public void push(E e) {
		if(size==0) {
			Node tmp = new Node(e, null);
			head = tmp;
			size++;
		}
		else {
			Node tmp = new Node(e, head);
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
			E tmp  = (E) head.getElement();
			head = head.getNext();
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
		return (E) head.getElement();
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
		
		public Node getNext() {
			return next;
		}
		
		public void setElement(T t) {
			element = t;
		}
		
	}

}
