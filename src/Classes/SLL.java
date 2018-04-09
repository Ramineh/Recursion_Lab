package Classes;

import java.util.ArrayList;

public class SLL<E> extends Pair{
	private static class Node<E> {
		private E element; 
		private Node<E> next;
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}
		public Node(E element) { this(element, null); } 
		public Node() { this(null, null); }
		public E getElement() { return element; }
		public void setElement(E element) { this.element = element; }
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> next) { this.next = next; }
		public Node<E> first() {
			return;
			// TODO Auto-generated method stub
			return null;
		}	
		
	}

	private Node<E> first = null; 
	private Node<E> last=null;
	private int size = 0; 	
	public void addFirst(E e) { 
		first = new Node<>(e, first); 
		size++; 
	}
	
	
              // returns string formed by elements in this list, separated by spaces
	public String toString() { 
		String s = ""; 
		Node<E> current = first; 
		while (current != null) { 
			s += " " + current.getElement(); 
			current = current.getNext(); 
		}
		return s; 
	}	
	
	public void reverse() {
		if (size>1) {
			first=recReverse(first).first();
		}
			
	}

	private Node<E> recReverse(Node<E> first2) {
		if (first2==null) return null;
		else {
			Node<E> rf=recReverse(first2.getNext());
			addLast(rf,first2);
			return rf;
		}
		// TODO Auto-generated method stub
		
	}


	private void addLast(Node<E> rf, Node<E> first2) {
		while(rf.getNext()!=null) {
			rf=rf.getNext();
			rf.setNext(first2);
			first2.setNext(null);
		}
	}
	
	public ArrayList<Pair<E>> consecutiveIncreasingPairs(){
		ArrayList<Pair<E>> result=new ArrayList();
		if (size>0) {
			recCIP(first, result);
		}
		return result;
		
	}


	private void recCIP(Node<E> first2, ArrayList<Pair<E>> result) {
		while(first!=null || first.getNext()!=null) {
			
				if ( (((Comparable<E>) first.getElement()).compareTo( first.getNext().getElement()))<0){
				result.add((Pair<E>) first.getNext().getElement());	
				recCIP(first.getNext(), result);
			}
		}
		
	}
	
	


	
}

