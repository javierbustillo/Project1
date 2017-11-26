
public interface RestaurantStack<E> {

	public void push(E e);
	
	public E pop();
	
	public int size();
	
	public E top();
	
}
