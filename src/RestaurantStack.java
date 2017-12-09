
public interface RestaurantStack<E> {
	/*
	 * Adds an element to the top of the stack
	 * @param E
	 */
	public void push(E e);
	/*
	 * Removes element from the top of the stack
	 * @return E
	 */
	public E pop();
	/*
	 * returns the size of the stack
	 * @return int 
	 */
	public int size();
	/*
	 * Shows the top element of the stack without removing the element
	 * @return E
	 */
	public E top();
	
}
