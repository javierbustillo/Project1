
public interface RestaurantQueue<E> {
	
	public E dequeue();
	
	public int size();
	
	public E first();

	public void enqueue(E e);


}
