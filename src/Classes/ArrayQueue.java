package Classes;



public class ArrayQueue<E> implements Queue<E> {
	private final static int INITCAP = 4; 
	private E[] elements; 
	private int first, size; 
	public ArrayQueue() { 
		elements = (E[]) new Object[INITCAP]; 
		first = 0; 
		size = 0; 
	}
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty()) return null; 
		return elements[first]; 
	
	}

	public E dequeue() {
		if (isEmpty())
			return null;
		E etr=elements[first];
		elements[first]=null;
		first=(first+1)%elements.length;
		size--;
		
		return etr;
		
	}
	private void changeCapacity(int newCapacity) {
		E[] temp=(E[]) new Object[newCapacity];
		for (int i=0; i<size;i++) {
			temp[i]=elements[(first+i)%size];
			elements[(first+i)%size]=null;
			
		}
		elements=temp;
		first=0;
	}
	@Override
	public void enqueue(E element) {
		if (size==elements.length)
			changeCapacity(2*size);
		elements[(first+size)%elements.length]=element;
		size++;
			
		
		
	}
	
	 private void sort(Queue<E> q) { // sorts the elements in q in non-decreasing order
		if (q.size() > 1) { // if size is <= 1, then nothing needs to be done
		
		Queue<E> q1, q2;
		// Initialize q1 and q2 to empty instances of ArrayQueue as implemented in previous lab.
		q1 = new ArrayQueue<>();
		q2 = new ArrayQueue<>();
		// split the elements of q in two halves (or close to), first half into q1 and second half into q2
		int n = q.size();
		for (int i=0; i<n/2; i++)
		q1.enqueue(q.dequeue());
		while (!q.isEmpty())
		q2.enqueue(q.dequeue());
		sort(q1); // recursively sort q1
		sort(q2); // recursively sort q2
		// What is left to do now is the merging operation . Given that q1 and q2 are each sorted,
		// efficiently combine is elements back into q so that they are placed in order from first to last.
		// This process efficiently exploits the property that both, q1 and q2 , are sorted.
		while (!q1.isEmpty() && !q2.isEmpty())
		if (((Comparable<E>) q1.first()).compareTo(q2.first()) <= 0)
		q.enqueue(q1.dequeue());
		else
		q.enqueue(q2.dequeue());
		// At this moment, one of the two queues, either q1 or q2 , is empty.
		Queue<E> r = (!q1.isEmpty() ? q1 : q2); // find which, q1 or q2 , is not empty yet
		while (!r.isEmpty())
		q.enqueue(r.dequeue());
		}
	 }
}		
		
