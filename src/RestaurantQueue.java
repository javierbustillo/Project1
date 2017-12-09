
public interface RestaurantQueue<E> {
	/*
	 * Removes element from the front of the queue
	 * @return E
	 */
	public E dequeue();
	/*
	 * Returns the size of the queue
	 * @return int
	 */
	public int size();
	/*
	 * Returns the first element in the queue without removing from queue
	 * @return E
	 */
	public E first();
	/*
	 * Adds an element to the queue
	 * @param E
	 */
	public void enqueue(E e);


}
